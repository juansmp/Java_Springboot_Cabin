package co.edu.usergioarboleda.cabin.cabin.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola-mundo")

public class HolaMundoController {
    @GetMapping("/")
    public String holaMundo() {
        return "<h1 style=\"background-color:DodgerBlue;\">Hello World</h1>";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }

}
