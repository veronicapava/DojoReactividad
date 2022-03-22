package com.sofka.reactividad.ejerciciodos;

import com.sofka.reactividad.ejerciciouno.ReactividadApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(ReactividadApplication.class);

        String frase = "Hola boba hijueputa";
        FiltroDePalabras frases = new FiltroDePalabras();
        frases.corriegiendoPalabras(frase).subscribe(x -> log.info(x.toString()));
    }
}


