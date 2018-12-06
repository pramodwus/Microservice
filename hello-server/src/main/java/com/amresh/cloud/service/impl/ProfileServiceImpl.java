package com.amresh.cloud.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amresh.cloud.dao.ProfileRepository;
import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;
import com.amresh.cloud.service.ProfileService;


@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	
	/**
	 * 
	 */
	
	@Transactional
	@Override
	public List<Profile> getAllProfileInfo() {
		
		return profileRepository.findAll();
	}

	
	/**
	 * 
	 */
	@Transactional
	@Override
	public ResponseStatus saveProfileData(Profile profile) {
		if(profileRepository.insert(profile)!=null) {
			return new ResponseStatus(201,"record create successfully");
		}else
		{
			return new  ResponseStatus(204,"record  was not save");
		}
	}

	
	/**
	 * 
	 */
	@Transactional
	@Override
	public ResponseStatus updateProfileData(Profile profile) {
		profileRepository.save(profile);
		return new ResponseStatus(201,"record update successfully");
	}
	
	
	

	/**
	 * 
	 */
	@Transactional
	@Override
	public ResponseStatus deleteProfileData(String id) {
		profileRepository.delete(id);
		return new ResponseStatus(204,"record deleted successfully");
	}

	/**
	 * 
	 */
	@Transactional
	@Override
	public List<Profile> getProfileByName(String firstName) {
		return	profileRepository.findByName(firstName);
	}

	
	/**
	 * 
	 */
	@Transactional
	@Override
	public Profile getProfileById(String id) {
		return	profileRepository.findById(id);
	}

}
