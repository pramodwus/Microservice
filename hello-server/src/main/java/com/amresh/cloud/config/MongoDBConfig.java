package com.amresh.cloud.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.amresh.cloud.dao.ProfileRepository;
import com.amresh.cloud.model.Address;
import com.amresh.cloud.model.Comment;
import com.amresh.cloud.model.Profile;

@EnableMongoRepositories(basePackageClasses = ProfileRepository.class)
@Configuration
public class MongoDBConfig {
	
	
	@Bean
    CommandLineRunner commandLineRunner(ProfileRepository profileRepository) {
        return strings -> {
	        //drop all data
        	profileRepository.deleteAll();
	        
	        //code for save data
			Profile amreshprofile = new Profile("Amresh", 10, new Address("Gurugram", "India"), Arrays
					.asList(new Comment("anil", 10, true), new Comment("vinod", 3, false), new Comment("briju", 7, true)

			));
			
			
			Profile brijeshprofile = new Profile("Brijesh vema ", 100, new Address("Nodia", "India"), Arrays
					.asList(new Comment("amit", 20, true), new Comment("meena", 5, false), new Comment("dheeraj", 7, true)

			));
	        	
	        	
			List<Profile> listProfile=Arrays.asList(amreshprofile,brijeshprofile);
			profileRepository.save(listProfile);	
					
        };
        	
	}	
       
        

}
