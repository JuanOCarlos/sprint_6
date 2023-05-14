package br.com.edusync.api.controlers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/ola", method = RequestMethod.GET)
    public String helloWorld() {

        return "Hello World !!";
    }

}
