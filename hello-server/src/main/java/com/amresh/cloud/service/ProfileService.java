package com.amresh.cloud.service;

import java.util.List;

import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;

public interface ProfileService {
	
	/**
	 * this method is used for get all profile data 
	 * @return Profile data 
	 */
	List<Profile> getAllProfileInfo();
	
	/**
	 * this method is used for save the data in mongo db
	 * @param profile take profile object as parameter
	 * @return ResponseStatus its contains code and message
	 */
	ResponseStatus saveProfileData(Profile profile);
	/**
	 * 
	 * @param profile
	 * @return
	 */
	ResponseStatus updateProfileData(Profile profile);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ResponseStatus deleteProfileData(String id);
	/**
	 * 
	 * @param firstName
	 * @return
	 */
	List<Profile> getProfileByName(String name);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Profile getProfileById(String id);

}
