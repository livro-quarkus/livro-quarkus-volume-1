package org.livro.quarkus;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class ExampleResource {
	
	@ConfigProperty(name = "ola.mensagem", defaultValue = "Hello")
	String mensagem;
	
	@ConfigProperty(name = "ola.nome")
	Optional<String> nome;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return mensagem + " " + nome.orElse("Quarkus") + "!";
    }
}