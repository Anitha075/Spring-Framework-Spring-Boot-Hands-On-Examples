package com.Learning.SpringBootRESTAPI.Controller;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

 @Value("${welcome.message}")
  private String welcomemessage;
  //  @RequestMapping(value="/",method = RequestMethod.GET)
    @GetMapping("/ani")
    public String helloworld()
    {

      return welcomemessage;
    }
}
