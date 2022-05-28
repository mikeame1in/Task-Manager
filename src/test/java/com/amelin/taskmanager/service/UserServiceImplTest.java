package com.amelin.taskmanager.service;

import com.amelin.taskmanager.model.User;
import com.amelin.taskmanager.repository.UserRepository;
import com.amelin.taskmanager.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	@InjectMocks
	private UserServiceImpl userService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private PasswordEncoder passwordEncoder;

	@Test
	void testCreate() {
		User user = new User();
		user.setPassword("Qwerty123!");

		String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";

		Mockito.doReturn(encodedPassword).when(passwordEncoder).encode(user.getPassword());

		userService.create(user);

		Mockito.verify(userRepository).save(user);

		Assertions.assertEquals(encodedPassword, user.getPassword());
	}

}
