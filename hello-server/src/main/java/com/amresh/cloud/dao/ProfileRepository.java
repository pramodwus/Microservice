package com.amresh.cloud.dao;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.amresh.cloud.model.Profile;
public interface ProfileRepository extends MongoRepository<Profile, String>{


	@Query(value="{name:?0}")
	List<Profile> findByName(String name);
	
	
	@Query(value="{id:?0}")
	Profile findById(String id);


}
