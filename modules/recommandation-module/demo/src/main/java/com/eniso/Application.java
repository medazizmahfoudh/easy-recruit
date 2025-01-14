package com.eniso;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "recommendation module documentation",
                version = "1.0"
        ), servers = @Server(url = "https://easy-recruit.com")
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}