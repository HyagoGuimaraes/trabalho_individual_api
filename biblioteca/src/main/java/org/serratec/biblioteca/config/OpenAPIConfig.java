package org.serratec.biblioteca.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Value("${dominio.openapi.dev-url}")
    private String devUrl;

    @Value("${dominio.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI bibliotecaOpenAPI() {

        Server devServer = new Server()
                .url(devUrl)
                .description("Servidor de Desenvolvimento");

        Server prodServer = new Server()
                .url(prodUrl)
                .description("Servidor de Produção");

        Contact contact = new Contact()
                .name("Equipe Biblioteca API")
                .url("https://www.meudominio.com.br")
                .email("contato@meudominio.com.br");

        License license = new License()
                .name("Apache License 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("API Biblioteca")
                .version("1.0.0")
                .description("API para gerenciamento de livros e publicações da biblioteca")
                .contact(contact)
                .license(license)
                .termsOfService("https://www.meudominio.com.br/termos");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
