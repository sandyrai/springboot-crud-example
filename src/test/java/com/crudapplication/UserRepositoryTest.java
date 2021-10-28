package com.crudapplication;import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crudapplication.user.User;
import com.crudapplication.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired private UserRepository repo;
	
	@Test
	public void testAddNew() {
		
		User user = new User();
		user.setEmail("sandeep@gmail.com");
		user.setPassword("sandeep123");
		user.setFirstname("sandeep");
		user.setLastname("kumar");
		
		User saveduser =repo.save(user);
		
		
		
		
	}

}
