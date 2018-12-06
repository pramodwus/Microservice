package com.amresh.cloud.dao;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;

public interface ProfileDao {
	
	
	 <T> ResponseEntity<T> execute(HttpEntity<MultiValueMap<String, String>> requestEntity, String endpoint, HttpMethod requestMethod);
	
	List<Profile> getData();
	
	
	ResponseStatus save(Profile profile);
	/**
	 * 
	 * @param profile
	 * @return
	 */
	 ResponseEntity<Profile> update(Profile profile);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ResponseStatus delete(String id);
	/**
	 * 
	 * @param firstName
	 * @return
	 */
	List<Profile> getByName(String name);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Profile getById(String id);
	
	
	
	
	

}
