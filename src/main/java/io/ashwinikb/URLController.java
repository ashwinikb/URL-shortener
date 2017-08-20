package io.ashwinikb;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URLController {

	private ApplicationProperties applicationProperties;
	private URLRepository urlRepository;

	@Autowired
	public void setApp(ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	@Autowired
	public void setURLRepository(URLRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("urlModel", new URLModel());
		return "home";
	}

	@RequestMapping("/short")
	public String shortUrl(Model model,@ModelAttribute URLModel urlModel) {
		String hash = HashUtil.hash(urlModel.getUrl());
		String baseURI = applicationProperties.baseURI;

		urlModel.setHash(hash);
		urlModel.setBaseURI(baseURI);

		//urlRepository.deleteAll();

		URLData domain = urlRepository.findFirstByHash(hash);
		if (domain != null && !domain.getUrl().isEmpty()) {
			System.out.println(domain.getHash());
			System.out.println(domain.getUrl());
		} else {
			URLData d = new URLData();
			d.setHash(hash);
			d.setUrl(urlModel.getUrl());
			urlRepository.save(d);
		}

		System.out.println(urlRepository.count());

		model.addAttribute("urlModel", urlModel);

		return "result";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void redirect(@PathVariable String id, HttpServletResponse resp) throws Exception {

		URLData domain = urlRepository.findFirstByHash(id);
		String url = domain.getUrl();

		if (url != null) {
			resp.sendRedirect(url);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
