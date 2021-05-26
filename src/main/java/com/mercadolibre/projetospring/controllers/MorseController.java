package com.mercadolibre.projetospring.controllers;

import com.mercadolibre.projetospring.models.Response;
import com.mercadolibre.projetospring.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    private MorseService morseService;

    @GetMapping(value = "/morse")
    public ResponseEntity<Response> test(@RequestParam String code) {
        return ResponseEntity.ok(new Response(morseService.translateMorse(code)));
    }
}