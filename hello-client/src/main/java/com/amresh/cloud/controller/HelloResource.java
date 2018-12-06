package com.amresh.cloud.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {


    /*@Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @GetMapping
    public String hello() {
        String url = "http://hello-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class)+ " including client";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Autowired
	private LoadBalancerClient loadBalancer;
	
	public void getEmployee() throws RestClientException, IOException {
		
		ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");
		
		System.out.println(serviceInstance.getUri());
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/rest/hello/server";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
