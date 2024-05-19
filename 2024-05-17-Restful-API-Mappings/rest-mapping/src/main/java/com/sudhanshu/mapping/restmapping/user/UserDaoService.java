package com.sudhanshu.mapping.restmapping.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sudhanshu.mapping.restmapping.user.exception.UserNotFoundException;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount;

	// fixed static users
	static {
		users.add(new User(++userCount, "arpit", LocalDateTime.now().minusYears(28)));
		users.add(new User(++userCount, "arohi", LocalDateTime.now().minusYears(20)));
		users.add(new User(++userCount, "ranjhna", LocalDateTime.now().minusYears(30)));
		users.add(new User(++userCount, "rovert", LocalDateTime.now().minusYears(15)));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserById(int id) {
		Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
		return user.orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deletebyId(int id) {
		User user = users.stream().filter(u->u.getId()==id).findFirst().orElseThrow(() -> new UserNotFoundException("Id: "+id+" Not Found"));
		users.remove(user);
	}
	
}
