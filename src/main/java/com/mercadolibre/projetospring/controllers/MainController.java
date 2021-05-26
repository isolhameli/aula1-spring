package com.mercadolibre.projetospring.controllers;

import com.mercadolibre.projetospring.models.Response;
import com.mercadolibre.projetospring.services.MorseService;
import com.mercadolibre.projetospring.services.RomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    private MorseService morseService;

    @Autowired
    private RomanService romanService;

    @GetMapping(value = "/morse")
    public ResponseEntity<Response> morse(@RequestParam String code) {
        return ResponseEntity.ok(new Response(morseService.translateMorse(code)));
    }

    @GetMapping(value="/roman")
    public ResponseEntity<Response> roman(@RequestParam String number) {
            return ResponseEntity.ok(new Response(romanService.romanToNumber(number).toString()));
        }
    }