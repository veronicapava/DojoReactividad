package com.sofka.reactividad.ejerciciodos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class FiltroDePalabras {

    private List<String> malaPalabra = List.of("webon", "gonorrea", "malparido", "estupido", "maldito", "maldita",
            "pirobo", "hijueputa");


    public Mono<String> corriegiendoPalabras(String frase){
        List<String> palabras = List.of(frase.split(" "));

        Mono<String> mono = Flux.fromIterable(palabras)
                .map(palabra -> (malaPalabra.contains(palabra)) ? "****" : palabra)
                .collect(joining(" "));
        return mono;
    }
}
