package com.iteram.utilidades;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operacion {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/");
    /*TODO añadir operaciones mas complejas en el futuro*/

    private static final Operacion[] valores = new Operacion[]{SUMA, RESTA, MULTIPLICACION, DIVISION};

    private String signo;

    Operacion(String signo) {
        this.signo = signo;
    }

    private String getSigno() {
        return this.signo;
    }

    /**
     * Parsea el parametro String valor en un objeto de tipo Operacion.
     * El valor del String puede ser tanto el nombre
     * ("suma", "resta"... indiferente mayusculas de minusculas) de la operacion
     * así como el signo ('+', '-', etc.)
     * @param valor
     * @return
     */
    @JsonCreator
    public static Operacion desdeValor(String valor) {

        for (int i = 0; i < valores.length; ++i) {
            Operacion opActual = valores[i];
            if (valor.equalsIgnoreCase(opActual.name()) ||
                    valor.equalsIgnoreCase(opActual.getSigno())) {
                return opActual;
            }
        }

        throw new RuntimeException("Operación no soportada para el valor: " + valor);
    }
}
