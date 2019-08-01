[![Build Status](https://travis-ci.org/e-ucm/rage-analytics-realtime.svg?branch=master)](https://travis-ci.org/e-ucm/rage-analytics-realtime) [![Coverage Status](https://coveralls.io/repos/github/RotaruDan/calculadora/badge.svg?branch=master)](https://coveralls.io/github/RotaruDan/calculadora?branch=master)

# Calculadora Spring-Boot
Calculadora como micro-servicio (API) utilizando Spring-boot y Maven con funcionalidades básicas de sumar, restar, multiplicar y dividir.
Leer el [enunciado](https://github.com/RotaruDan/calculadora/blob/master/enunciado.md) para más información.

Comunicación a través de una API REST (p.e. ```GET /api/calcula?primero=2&segundo=3&operacion=suma```)

Contiene la integración de las librerías locales [tracer](https://github.com/RotaruDan/calculadora/tree/master/lib) en maven mediante el [maven-install-plugin](https://github.com/RotaruDan/calculadora/blob/master/pom.xml#L75) por lo que es necesario ejecutar `mvn clean install` antes de poder utilizar el proyecto.

## Requisitos previos
Necesario disponer de la ultima versión de Maven instalada. Tambien hace falta tener JAVA instalado en el sistema.

## Como utilizar

1. Descargar el repositorio girhub
2. Ejecutar una verificación de Maven
3. Instalación limpia de Maven
4. Ejecutar el JAR de la carpeta /target

Abrir una consola y ejecutar:

```
git clone https://github.com/RotaruDan/calculadora
cd calculadora
mvn validate
mvn verify
mvn clean install
```

A estas alturas debería haberse generado una carpeta `/target` con el JAR definitivo del programa `calculadora-spring-boot.jar`. Para ejecutarlo:

`java -jar target/calculadora-spring-boot.jar`

Con estos pasos deberiamos tener a nuestra disposición una API REST escuchando en `http://localhost:8080/api/calcula`

Si has tenido algun error con la ejecución de las instrucciones anteriores, en el proyecto ya hay un JAR definitivo compilado con todas las dependencias, si quieres probar el proyecto directamente puedes (1) clonar el proyecto en local y (2) ejecutar el JAR precompilado [calculadora-spring-boot.jar](https://github.com/RotaruDan/calculadora/blob/master/target/calculadora-spring-boot.jar).

```
git clone https://github.com/RotaruDan/calculadora
java -jar calculadora/target7calculadora-spring-boot.jar
```

## API REST
Si has seguido correctamente los pasos anteriores, deberias tener el puerto 8080 abierto y escuchando peticiones REST GET.

Los parámetros se le deben pasar por URL en formato URLEncoded. Los parametros son los siguientes `primero` el primer numero de la operación,
`segundo` el segundo numero de la operación y `operacion` una cadena de texto describiendo la operación a realizar (valores aceptados `suma`, `resta`, `multiplicación`, `division`). Por ejemplo:

`GET http://localhost:8080/api/calcula?primero=4&segundo=9&operacion=suma`

El resultado será un valor numerico con decimales (4 + 9 = 13):

`13.0`

## Ejecutar tests

Si has clonado e instalado todas las dependencias de maven en local, para ejecutar los [tests](https://github.com/RotaruDan/calculadora/tree/master/src/test/java) debes ejecutar el comando `mvn clean test`.

Si has encontrado algun error, no dudes en abrir una [issue](https://github.com/RotaruDan/calculadora/issues). Licencia Apache 2.0.
