package com.mercadolibre.projetospring.services;

import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Map.entry;

@Service
public class RomanService {

    private Map<String, Integer> romanMap = Map.ofEntries(

            entry("I", 1),
            entry("V", 5),
            entry("X", 10),
            entry("L", 50),
            entry("C", 100),
            entry("D", 500),
            entry("M", 1000)
    );

    public Integer romanToNumber(String roman){
        String[] numbers = roman.split("");

        Integer sum = 0;
        Integer previousNumber = 0;

        for (String item : numbers) {
            Integer aux = romanMap.get(item.toUpperCase());

            if (aux == null) continue;

            if (aux > previousNumber) {
                sum += aux;
                sum -= previousNumber * 2;
            } else {
                sum += aux;
            }

            previousNumber = aux;
        }

        return sum;
    }
}
