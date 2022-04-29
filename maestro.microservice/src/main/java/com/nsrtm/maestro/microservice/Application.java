package com.nsrtm.maestro.microservice;

import com.nsrtm.maestro.microservice.config.CORS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	@Autowired
	private CORS cors;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(cors.allowCredentials); // you USUALLY want this
		config.setAllowedOrigins(Arrays.asList(cors.allowOrigins.split(",")));
		config.setAllowedHeaders(Arrays.asList(cors.allowHeaders.split(",")));
		config.setAllowedMethods(Arrays.asList(cors.allowMethods.split(",")));
		config.setMaxAge(Duration.ofSeconds(cors.getMaxAge()));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration(cors.getMapping(), config);

		return new CorsFilter(source);
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<?, ?> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		return template;
	}

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig() //
				.prefixCacheNameWith(this.getClass().getPackageName() + ".") //
		.entryTtl(Duration.ofHours(1))
		.disableCachingNullValues();

		return RedisCacheManager.builder(connectionFactory) //
				.cacheDefaults(config) //
				.build();
	}
}
