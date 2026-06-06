package com.example.demo.serviceimpl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.jparepository.UserRepository;
@Service
public class CustomUserdetailsService implements UserDetailsService{
	
	
	private final UserRepository userRepository;
	
	public CustomUserdetailsService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	 
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found: "+ username));
		/*
		 * return new
		 * org.springframework.security.core.userdetails.User(user.getUsername(),
		 * user.getPassword(),user.getRoles().stream(). map(role -> new
		 * SimpleGrantedAuthority(role.)))
		 */
		return null;
		
	}

}
