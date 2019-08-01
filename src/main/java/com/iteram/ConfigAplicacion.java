package com.iteram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.iteram")
@EnableAutoConfiguration
public class ConfigAplicacion extends SpringBootServletInitializer {

    /**
     * Añadimos {@link ConfigAplicacion} al resto de archiovos del programa
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ConfigAplicacion.class);
    }


    /**
     * Comienzo del programa ejecutando {@link ConfigAplicacion}
     * con los argumentos del programa
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigAplicacion.class, args);
    }
}
