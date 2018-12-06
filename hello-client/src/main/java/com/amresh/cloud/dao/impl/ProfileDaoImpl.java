package com.amresh.cloud.dao.impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.amresh.cloud.dao.ProfileDao;
import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;

@Repository
public class ProfileDaoImpl implements ProfileDao{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	
	
	@Override
	public List<Profile> getData() {
		String url = getBaseUrl()+"/rest/profile/all";
        Profile[] allprofiledata=  restTemplate.getForObject(url,Profile[].class);
        return Arrays.asList(allprofiledata);
	}

	
	
	
	@Override
	public ResponseStatus save(Profile profile) {
		String url = getBaseUrl()+"/rest/profile/save";
		return restTemplate.postForObject(url, profile, ResponseStatus.class);
		
	}

	@Override
	public ResponseEntity<Profile> update(Profile profile) {
		
		String url = getBaseUrl()+"/rest/profile/update";
		HttpEntity<Profile> request = new HttpEntity<>(profile);
		ResponseEntity<Profile> response = restTemplate.exchange(url, HttpMethod.PUT, request, Profile.class);
		
		return response;
		
	}

	@Override
	public ResponseStatus delete(String id) {
		String url =getBaseUrl()+"/rest/profile/delete/{id}";
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("id", id);
		// HttpEntity<String> request = new HttpEntity<>("");
		 //ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
			
		 restTemplate.delete(url, params);
		return new ResponseStatus(200,"Deleted successfully");
	}
	
	
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> ResponseEntity<T> execute(HttpEntity<MultiValueMap<String, String>> requestEntity, String endpoint, HttpMethod requestMethod) {
		ResponseEntity<String> response = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
		 response = restTemplate.exchange(endpoint, requestMethod, requestEntity,
					String.class);
		} catch (Exception e) {
			
		}
		return (ResponseEntity<T>) response;
	}
	
	
	

	@Override
	public List<Profile> getByName(String name) {
		String url =getBaseUrl()+"/rest/profile/name/{name}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name",name);
		Profile[] prof= restTemplate.getForObject(url,Profile[].class, params);
		 return Arrays.asList(prof);
	}

	
	
	
	@Override
	public Profile getById(String id) {
		
		String url =getBaseUrl()+"/rest/profile/id/{id}";
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("id",id);
		
		 Profile prof= restTemplate.getForObject(url,Profile.class, params);
		 return prof;
		
	}
	
	
	
	private String getBaseUrl()
	{
		ServiceInstance serviceInstance=loadBalancer.choose("hello-server");
		System.err.println("************************"+serviceInstance.getUri());
		String baseUrl=serviceInstance.getUri().toString();
		return baseUrl;
	}
	
	

}
