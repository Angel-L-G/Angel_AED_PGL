package es.iespto.agl.TresEnRaya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

	

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api Gente", version = "v1"))
public class SwaggerConfig{
	@Bean
	public OpenAPI customizeOpenAPI() {
		final String securitySchemeName = "bearerAuth";
		return new OpenAPI()
			.addSecurityItem(new SecurityRequirement()
					.addList(securitySchemeName))
			.components(new Components()
					.addSecuritySchemes(securitySchemeName, new
			io.swagger.v3.oas.models.security.SecurityScheme()
			.name(securitySchemeName)
			.type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
			.scheme("bearer")
			.bearerFormat("JWT")));
	}
}
