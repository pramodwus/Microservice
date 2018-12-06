package com.amresh.cloud.service.impl;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.amresh.cloud.dao.ProfileDao;
import com.amresh.cloud.model.Profile;
import com.amresh.cloud.model.ResponseStatus;
import com.amresh.cloud.service.ProfileClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProfileClientServiceImpl implements ProfileClientService {

	@Qualifier("profileDaoImpl")
	@Autowired
	private ProfileDao profileDao;
	
	
	
	@HystrixCommand(fallbackMethod = "_getAllProfileInfoClient", groupKey="alldata_groupKey",commandKey = "alldata_commandKey",threadPoolKey = "alldataThread" )
	@Override
	public List<Profile> getAllProfileInfoClient() {
		return profileDao.getData();
		
	}
	
	
	public List<Profile> _getAllProfileInfoClient(Throwable hystrixCommand) {
		 return Arrays.asList(new Profile());
	 }
	
	
	
	
	@HystrixCommand(fallbackMethod = "_saveProfileDataClient", groupKey="savedata_groupKey",commandKey = "savedata_commandKey",threadPoolKey = "savedataThread" )
	@Override
	public ResponseStatus saveProfileDataClient(Profile profile) {
		return profileDao.save(profile);
		
	}
	
	
	public ResponseStatus _saveProfileDataClient(Profile profile) {
		return null;
	}
	
	
	
	
	@HystrixCommand(fallbackMethod = "_updateProfileDataClient", groupKey="updatedata_groupKey",commandKey = "updatedata_commandKey",threadPoolKey = "updatedataThread" )
	@Override
	public ResponseStatus updateProfileDataClient(Profile profile) {
		ResponseEntity<Profile> response =profileDao.update(profile);
		if(response.getStatusCodeValue()==200)
		return new ResponseStatus(201,"record update successfully");
		else
		return new ResponseStatus(204,"recordnot updated successfully");
	}
	
	
	
	public ResponseStatus _updateProfileDataClient(Profile profile) {
	return 	null;
	}
	
	
	
	@HystrixCommand(fallbackMethod = "_deleteProfileDataClient", groupKey="deletedata_groupKey",commandKey = "deletedata_commandKey",threadPoolKey = "deletedataThread" )
	@Override
	public ResponseStatus deleteProfileDataClient(String id) {
		ResponseStatus response =profileDao.delete(id);
		return response;
	}
	
	public ResponseStatus _deleteProfileDataClient(String id) {
		return null;
	}
	
	
	
	@HystrixCommand(fallbackMethod = "_getProfileByNameClient", groupKey="namedata_groupKey",commandKey = "namedata_commandKey",threadPoolKey = "namedataThread" )
	@Override
	public List<Profile> getProfileByNameClient(String name) {
		
		return profileDao.getByName(name);
		
	}
	
	
	public List<Profile> _getProfileByNameClient(String name) {
		
		return null;
		
	}
	
	
	
	
	
	@HystrixCommand(fallbackMethod = "_getProfileByIdClient", groupKey="iddata_groupKey",commandKey = "iddata_commandKey",threadPoolKey = "iddataThread" )
	@Override
	public Profile getProfileByIdClient(String id) {
		
		
		return profileDao.getById(id);
	}
	
	public Profile _getProfileByIdClient(String id) {
		
		
		return null;
	}
	
	
	
	
}
