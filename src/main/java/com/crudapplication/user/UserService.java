package com.crudapplication.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired private UserRepository repo;
	
	
	public List<User> listAll(){
		
		return  (List<User>) repo.findAll();
}


	public void save(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}
	
	
	public User get(Integer id) throws UserNotFoundException {
	Optional<User>result=repo.findById(id);
		
	if(result.isPresent()) {
		return result.get();
	}
	
	throw new UserNotFoundException("could not found any user with id " + id);
		
	}
	
	
	public void delete(Integer id) throws UserNotFoundException {
		Long count = repo.countById(id);
		if(count == null || count ==0) {
			throw new UserNotFoundException("could not found any user with id " + id);
		}
		repo.deleteById(id);
	}
	
}
