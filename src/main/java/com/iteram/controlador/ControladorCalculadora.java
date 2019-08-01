package com.iteram.controlador;

import com.iteram.servicios.IServicioCalculadora;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Gestiona el método GET /api/calcula
 */
@RestController
@RequestMapping("/api")
public class ControladorCalculadora {

    @Autowired
    private IServicioCalculadora servicioCalculadora;

    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calcula")
    public ResponseEntity<Double> calcula(@RequestParam(name = "primero") BigDecimal primerNumero,
                                            @RequestParam(name = "segundo") BigDecimal segundoNumero,
                                            @RequestParam(name = "operacion") String operacion) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, operacion);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
