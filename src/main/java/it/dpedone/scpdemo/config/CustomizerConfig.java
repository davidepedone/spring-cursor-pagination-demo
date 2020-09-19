package it.dpedone.scpdemo.config;

import it.davidepedone.scp.data.web.config.CursorPageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Configuration
public class CustomizerConfig {

	@Bean
	public CursorPageableHandlerMethodArgumentResolverCustomizer customizer() {
		return c -> {
			c.setContinuationTokenParameterName("ct");
			c.setSizeParameterName("sz");
		};
	}

}
