package example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api.**")
public class TestEnv {

	@GetMapping (value = "api.env")
	public String print(){
		return  "Hello I'm here";
	}
}
