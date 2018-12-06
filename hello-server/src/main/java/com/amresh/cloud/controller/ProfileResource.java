package com.amresh.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;
import com.amresh.cloud.service.ProfileService;

@RestController
@RequestMapping("/rest/profile")
public class ProfileResource {
	
	/*
	POST	/rest/profile	Create a book	201
	GET	/rest/profile/{isbn}	Read a book	200
	PUT	/rest/profile/{isbn}	Update a book	200
	DELETE	/rest/profile/{isbn}	Delete a book	204
	PATCH	/rest/profile/{isbn}	Update book description	200
	GET	/rest/profile	Retrieve all books by pagination, sorting and ordering	200, 204, 206
	*/
	private static final Logger LOGGER=LoggerFactory.getLogger(ProfileResource.class);
	
	
	@Qualifier("profileServiceImpl")
	@Autowired
	private ProfileService profileService;
	
	
	
	
	@GetMapping("/all")
    public List<Profile> getAll() {
		LOGGER.info(" get response for get all profile data");
        return profileService.getAllProfileInfo();
    }
	
	
	
	
	@PostMapping("/save")
	public ResponseStatus insert(@RequestBody Profile  profile)
	{
		LOGGER.info("  response for save profile data on server");
		return profileService.saveProfileData(profile);
		 
	}
	
	
	
	
	
	
	@PutMapping("/update")
	public ResponseStatus update(@RequestBody Profile  profile)
	{
		LOGGER.info(" get response for save profile data on server");
		return profileService.updateProfileData(profile);
		
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseStatus delete(@PathVariable("id") String id)
	{
		return profileService.deleteProfileData(id);
	}
	
	
	
	
	@GetMapping("/id/{id}")
    public Profile getPersonById(@PathVariable("id")  String  id) {
        return profileService.getProfileById(id);
    }
	
	
	
	@GetMapping("/name/{name}")
    public List<Profile> getPersonByFirstName(@PathVariable("name")  String  name) {
        return profileService.getProfileByName(name);
    }
	
	
	
	
	
	
	

}
