package com.mc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {

    @RequestMapping("/")
    String index(Model model) {
    	model.addAttribute("testing", "String from attribute");
    	model.addAttribute("mymap", createMap());
    	model.addAttribute("myMapWithListValue", createMapWithListOfValues());
        return "index";
    }

    private Map<String, String> createMap() {
		return createList().stream().collect(Collectors.toMap(e -> "keyFor" + e, e -> e));
	}
    
    private Map<String, List<String>> createMapWithListOfValues() {
    	return createList().stream().collect(Collectors.toMap(e -> "keyForList" + e, e -> createRandomList(e)));
    }

	private List<String> createList() {
		return Arrays.asList("text1","text2","text3");
	}
	private List<String> createRandomList(String name) {
		return Arrays.asList(concatWithRandomisedSuffix(name),concatWithRandomisedSuffix(name),concatWithRandomisedSuffix(name));
	}

	private String concatWithRandomisedSuffix(String txt) {
		return txt + "----" + randomString();
	}

	private String randomString() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }
}
