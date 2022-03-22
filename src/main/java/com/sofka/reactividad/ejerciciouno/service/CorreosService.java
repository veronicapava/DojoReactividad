package com.sofka.reactividad.ejerciciouno.service;

import com.sofka.reactividad.ejerciciouno.ReactividadApplication;
import com.sofka.reactividad.ejerciciouno.model.Correo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

public class CorreosService {

    private static final Logger log = LoggerFactory.getLogger(ReactividadApplication.class);

    public Flux<Correo> distinc(Flux<Correo> lista){
        return lista.distinct();
    }

    public Flux<Correo> filtro(Flux<Correo> filtro, String dominio){
        return filtro.filter(x -> x.getCorreo().contains(dominio));
    }

    public Flux<String> condicionesCorreo(Flux<Correo> lista){
        return lista.map(correo ->{
                    if (!correo.getCorreo().contains("@")){
                        correo.setCorreo(correo.getCorreo().concat("@gmail.com"));
                    }
                    return ("Correos listo para ser utilizados" + correo);
                }
        );
    }

    public Mono<Long> cantidadDeCorreos(Flux<Correo> lista){
        lista.collectList();
        return lista.count();
    }

    public Mono<Long> cantidadDeCorreosPorDominio(Flux<Correo> correoFlux, String dominio){
        String dominioListo = dominio.toLowerCase(Locale.ROOT);
        correoFlux.collectList();
        return correoFlux.filter(x -> x.getCorreo().contains(dominioListo)).count();
    }

    public Flux<Correo> correoEnviado (Flux<Correo> correoFlux){
        correoFlux.map(x -> {
            if (x.isCorreoEnviado()==false){
                x.setCorreoEnviado(true);
            }
            return  ("Estado cambiado: " + correoFlux);
        });
        return correoFlux;
    }

}
