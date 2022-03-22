package com.sofka.reactividad;

import com.sofka.reactividad.ejerciciouno.model.Correo;
import com.sofka.reactividad.ejerciciouno.service.Correos;
import com.sofka.reactividad.ejerciciouno.service.CorreosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@SpringBootApplication
public class ReactividadApplication{

	static Correos cor = new Correos();
	static List<Correo> lista = cor.correos();
	static Flux<Correo> correoFlux = Flux.fromStream(lista.parallelStream()).cache();


	public static void main(String[] args) {
		SpringApplication.run(ReactividadApplication.class, args);
		Logger log = LoggerFactory.getLogger(ReactividadApplication.class);

		CorreosService correoService = new CorreosService();

		Flux<Correo> distinc = correoService.distinc(correoFlux);
		distinc.subscribe(correo -> log.info(correo.toString()));

		Flux<Correo> filtro = correoService.filtro(correoFlux);
		filtro.subscribe(correo -> log.info(correo.toString()));

		Mono<Long> cantidadDeCorreos = correoService.cantidadDeCorreos(correoFlux);
		cantidadDeCorreos.subscribe(correo -> log.info(correo.toString()));



	}

}
