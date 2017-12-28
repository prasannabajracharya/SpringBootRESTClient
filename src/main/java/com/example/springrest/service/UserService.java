package com.example.springrest.service;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springrest.domain.User;

@Service
public class UserService {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/rs/user/";
	
	 /* GET */
    public User getUser(Long id){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI + id, User.class);
        System.out.println(user);
        return user;
    }
    
    /* GET */
    public List<User> getAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
          
        RestTemplate restTemplate = new RestTemplate();

		List<User> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return usersMap;
    }
    
    /* POST */
    public void createUser(User user) {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(REST_SERVICE_URI+"/create/", user, User.class);
        //System.out.println("Location : "+uri.toASCIIString());
    }
    
    /* PUT */
    public void updateUser(User user, Long id) {
        System.out.println("Testing update User API----------");
		user.setId(id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(REST_SERVICE_URI+"/update/" + id, user);
        System.out.println(user);
    }
    
    /* DELETE */
    public void deleteUser(User user, Long id) {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(user);
        restTemplate.delete(REST_SERVICE_URI+"/delete/" + id);
        
    }
}
