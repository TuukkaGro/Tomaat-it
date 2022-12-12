package com.tomaatit.DogClothing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tomaatit.DogClothing.domain.UserRepository;
import com.tomaatit.DogClothing.web.UserDetailServiceImpl;

class UserDetailServiceImplTest {

	private UserDetailServiceImpl userDetailService;
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		// Set up the mock user repository
		userRepository = Mockito.mock(UserRepository.class);
		userDetailService = new UserDetailServiceImpl(userRepository);
	}

	@Test
	void testLoadUserByUsername_userNotFound() {
		// Configure the mock user repository to return null when findByUsername is
		// called
		Mockito.when(userRepository.findByUsername("username")).thenReturn(null);

		// Call the loadUserByUsername method with an invalid username
		assertThrows(UsernameNotFoundException.class, () -> {
			userDetailService.loadUserByUsername("username");
		});
	}

}