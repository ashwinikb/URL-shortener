package io.ashwinikb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class URLController {


	@RequestMapping("/shorturl")
    public String shortURL(Model model) {
        model.addAttribute("url", new Url());
        return "shortURL";
    }
	
	@RequestMapping("/short-this-url")
    public String shortThisURL(@ModelAttribute Url url) {
        return "results";
    }
	

//    @PostMapping("/shorturl")
//    public String urlSubmit(@ModelAttribute Url url) {
//        return "result";
//    }

}
