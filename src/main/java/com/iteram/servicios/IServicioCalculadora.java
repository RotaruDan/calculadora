package com.iteram.servicios;

import com.iteram.utilidades.Operacion;

import java.math.BigDecimal;

public interface IServicioCalculadora {

    /**
     * Method is used for calculation for given numbers and operator type
     * Calcula para los números proporcionados como argumentos el resutlado de
     * la operación
     *
     * @param primerNumero
     * @param segundoNumero
     * @param operacion sumar, restar, multiplicar, dividir...
     * @return el resultado de la operación (depende del tipo de operación). Se ha decidido que valor doble
     *              es más que suficiente para representar la operación
     */
    double calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion);
}
