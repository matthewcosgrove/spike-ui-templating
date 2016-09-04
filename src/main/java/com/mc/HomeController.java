package com.mc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {

    @RequestMapping("/")
    String index(Model model) {
    	model.addAttribute("testing", "String from attribute");
    	model.addAttribute("mylist", createList());
        return "index";
    }

    private List<String> createList() {
		return Arrays.asList("text1","text2","text3");
	}

	@RequestMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }
}
