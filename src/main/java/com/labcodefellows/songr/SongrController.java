package com.labcodefellows.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongrController {
    @ResponseBody
    @GetMapping("/hello-world")
    public String testMethodHere() {
        return "Hello World";
    }

    @GetMapping("/capitalize/{greeting}")
    public String renderCapHello(Model m, @PathVariable String greeting) {
        m.addAttribute("greeting", greeting.toUpperCase());
        return "/hello.html";
    }

    @GetMapping("/albums")
    public String albums(Model m) {
        Album[] getAlbums = {
                new Album("Banana Pancakes", "Jack Johnson", 852, 5, "/images/bananaPancakes.png"),
                new Album("The Word is Alive", "Casting Crowns", 1001, 3, "/images/wordIsAlive.png"),
                new Album("Back in Black", "ACDC", 584, 4, "/images/backInBlack.png")

        };
       m.addAttribute("albums", getAlbums);
       return "albums";
    }
}
