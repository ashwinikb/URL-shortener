package io.ashwinikb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLController {

	Map<String, String> database = new HashMap<String, String>();

	@RequestMapping("/shorturl")
	public String shortURL(Model model) {
		model.addAttribute("url", new Url());
		return "shortURL";
	}

	@RequestMapping("/short-this-url")
	public String shortThisURL(@ModelAttribute Url url) {
		String hash = ShortUrlUtil.hash(url.getFullURL());
		String baseURL = "localhost:8080/";
		String finalURL = baseURL + hash;

		url.setShortURL(finalURL);
		url.setFullURL(url.getFullURL());

		database.put(url.getShortURL(), url.getFullURL());

		System.out.println("Contents of Database");
		Iterator<Entry<String, String>> iterator = database.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println("[" + next.getKey() + "," + next.getValue() + "]");

		}

		return "results";
	}

}
