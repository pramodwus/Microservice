package com.amresh.cloud.service;

import java.util.List;

import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;

public interface ProfileClientService {
	
	
	/**
	 * this method is used for get all profile data 
	 * @return Profile data 
	 */
	List<Profile> getAllProfileInfoClient();
	
	/**
	 * this method is used for save the data in mongo db
	 * @param profile take profile object as parameter
	 * @return ResponseStatus its contains code and message
	 */
	ResponseStatus saveProfileDataClient(Profile profile);
	/**
	 * 
	 * @param profile
	 * @return
	 */
	ResponseStatus updateProfileDataClient(Profile profile);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ResponseStatus deleteProfileDataClient(String id);
	/**
	 * 
	 * @param firstName
	 * @return
	 */
	List<Profile> getProfileByNameClient(String name);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Profile getProfileByIdClient(String id);

}
