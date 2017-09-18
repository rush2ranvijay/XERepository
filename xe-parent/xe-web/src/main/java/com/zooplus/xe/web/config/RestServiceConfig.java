package com.zooplus.xe.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestServiceConfig {

	@Bean
	public RestTemplate createRestTemplate(final ClientHttpRequestFactory clientHttpRequestFactory) {
		return new RestTemplate(clientHttpRequestFactory);
	}
	
	@Bean
	public ClientHttpRequestFactory createClientHttpRequestFactory(
			@Value("${currency.service.connect.timeout}") final int connectTimeout, 
			@Value("${currency.service.read.timeout}") final int readTimeout){
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectTimeout(connectTimeout);
		httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);
		return httpComponentsClientHttpRequestFactory;
	}

}
