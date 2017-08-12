package hr.tvz.gudicek.elumen.elumenapi.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello() {
		return ("Hello, SpringBoot on Wildfly");
	}

	@GetMapping("/get")
	public String getMapping() {
		return "sim pa tam get mapping radi!!!";
	}

}