package io.ashwinikb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URLController {

	Map<String, String> database = new HashMap<String, String>();
	// MongoClient mongoClient = new MongoClient(new
	// MongoClientURI("mongodb://localhost:27017"));

	@RequestMapping("/")
	public String shortURL(Model model) {
		model.addAttribute("url", new Url());
		return "shortURL";
	}

	@RequestMapping("/short")
	public String shortThisURL(@ModelAttribute Url url) {
		String hash = ShortUrlUtil.hash(url.getFullURL());
		String baseURL = "localhost:8080/";
		String shortURL = baseURL + hash;

		url.setShortURL(shortURL);

		database.put(hash, url.getFullURL());

		// System.out.println("Contents of Database");
		// Iterator<Entry<String, String>> iterator =
		// database.entrySet().iterator();
		//
		// while (iterator.hasNext()) {
		// Entry<String, String> next = iterator.next();
		// System.out.println("[" + next.getKey() + "," + next.getValue() +
		// "]");
		//
		// }

		return "results";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void redirect(@PathVariable String id, HttpServletResponse resp) throws Exception {
		// final String url = redis.opsForValue().get(id);
		final String url = database.get(id);

		if (url != null)
			resp.sendRedirect(url);
		else
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

}
