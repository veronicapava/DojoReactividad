package com.sofka.reactividad.ejerciciouno.service;

import com.sofka.reactividad.ReactividadApplication;
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

    public Flux<Correo> filtro(Flux<Correo> filtro){
        return filtro.filter(x -> x.getCorreo().contains("@gmail.com"));
            /* else {
                if (x.getCorreo().contains("@hotmail.com")) {
                    log.info("si hay correos hotmail");
                } else {
                    log.info("si hay correos outlook");
                }
            }*/
    }

    public Flux<String> map(Flux<Correo> lista){
        return lista.map(
                correo -> correo.getCorreo()
                        .toLowerCase(Locale.ROOT)

        );
    }

    public Mono<Long> cantidadDeCorreos(Flux<Correo> lista){
        lista.collectList();
        return lista.count();
    }
}
