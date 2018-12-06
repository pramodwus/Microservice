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
import com.amresh.cloud.service.ProfileClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/profile")
public class ProfileResourceClient {
	
	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProfileResourceClient.class);
	
	
	@Qualifier("profileClientServiceImpl")
	@Autowired
	private ProfileClientService profileClientService;
	

	@ApiOperation(value = "Api for display all records of profile details.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Profile",response =Profile.class),
            @ApiResponse(code = 404, message = "Profile Details does not exist"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping("/all")
    public List<Profile> getAllProfileData() {
		
		LOGGER.info("call get request from client side for get all profile data");
        return profileClientService.getAllProfileInfoClient();
        
    }
	
	
	 
    
	@ApiOperation(value = "Api for save the data.")
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful save the profile data", response = ResponseStatus.class),
            
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping("/save")
	public ResponseStatus addProfileData(@RequestBody Profile  profile)
	{
		LOGGER.info("Send data from client side for save profile data ");
		return profileClientService.saveProfileDataClient(profile);
		 
	}
    
    
    
	@ApiOperation(value = "Api for Update the data.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful update  data", response = ResponseStatus.class),
            
            @ApiResponse(code = 500, message = "Internal server error") })
    @PutMapping("/update")
	public ResponseStatus updateProfileData(@RequestBody Profile  profile)
	{
		LOGGER.info("Send data from client side for update profile data ");
		return profileClientService.updateProfileDataClient(profile);
		 
	}
    
    
	
	@ApiOperation(value = "Api for Delete the data.")
	@ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successful deleted  data", response = ResponseStatus.class),
            
            @ApiResponse(code = 500, message = "Internal server error") })
    @DeleteMapping("/delete/{id}")
    public ResponseStatus deleteProfileData(@PathVariable("id") String id)
	{
		LOGGER.info("call delete request from client side for delete profile info of id ");
		return profileClientService.deleteProfileDataClient(id);
		 
	}
    
    
	
	@ApiOperation(value = "Api for display records filter by id ")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Person ",response =Profile.class),
            @ApiResponse(code = 404, message = "Person Details does not exist"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping("/id/{id}")
    public Profile getPersonById(@PathVariable("id")  String  id) {
    	
		LOGGER.info("call get request from client side for get particular profile data based on id");
		return profileClientService.getProfileByIdClient(id);
    }
    
    
	@ApiOperation(value = "Api for display records filter by first name")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Person ",response =Profile.class),
            @ApiResponse(code = 404, message = "Person Details does not exist"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping("/name/{name}")
    public List<Profile> getPersonByname(@PathVariable("name")  String  name) {
    	
		LOGGER.info("call get request from client side for get particular profile data based on name");
		return profileClientService.getProfileByNameClient(name);
    }
    
    
    
    
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
    
    
    
    
    
    
    
	
	
	

}
