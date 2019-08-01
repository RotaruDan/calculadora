package com.iteram.servicios;

import com.iteram.utilidades.Operacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementación básica de la interfaz {@link IServicioCalculadora}
 */
@Service
public class ServicioCalculadora implements IServicioCalculadora {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicioCalculadora.class);


    /**
     * Intentamos convertir la operación, sino podemos lanzamos un error,
     * y realizamos la operación correspondiente
     * @param primerNumero
     * @param segundoNumero
     * @param opTexto
     * @return
     */
    @Override
    public double calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String opTexto) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculando resultado para : {} {} {}", primerNumero, segundoNumero, opTexto);
        }

        Operacion operacion = Operacion.desdeValor(opTexto);

        if(operacion == null) {
            throw new RuntimeException("Operación imposible de procesar: " + opTexto);
        }

        switch (operacion) {
            case SUMA:
                return primerNumero.add(segundoNumero).doubleValue();
            case RESTA:
                return primerNumero.subtract(segundoNumero).doubleValue();
            case MULTIPLICACION:
                return primerNumero.multiply(segundoNumero).doubleValue();
            case DIVISION:
                return primerNumero.divide(segundoNumero, 2, RoundingMode.HALF_UP).doubleValue();
            default:
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error("Operación no soportada para ser calculada: {}", operacion);
                }
                throw new RuntimeException("Operación no soportada para ser calculada: " + operacion.toString());

        }
    }
}
