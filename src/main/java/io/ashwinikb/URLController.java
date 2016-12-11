package io.ashwinikb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLController {

	
    @RequestMapping("/short-url")
    public String shortURL(Model model) {
//        model.addAttribute("name", name);

    	return "shortURL";
    }

}
