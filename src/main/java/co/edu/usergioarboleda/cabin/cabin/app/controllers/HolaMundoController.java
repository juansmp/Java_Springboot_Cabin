package co.edu.usergioarboleda.cabin.cabin.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.cabin.cabin.app.models.Cabin;

@RestController
@RequestMapping("/hola-mundo")

public class HolaMundoController {
    @GetMapping("/")
    public String holaMundo() {
        Cabin nuevaCabana = new Cabin();

        return nuevaCabana.toString();
        // return "<h1 style=\"background-color:DodgerBlue;\">Hello World</h1><h2
        // style=\"color:#ff0;\">Hello World</h1>";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }

}
