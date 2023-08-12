package com.HTT.company.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HTT.company.entity.Users;
import com.HTT.company.repository.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsersRepository userDao;

	@Autowired
	private UsersRepository usersDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		Users usersEntity = this.usersDao.findByUsersName(userName);

		GrantedAuthority authority = new SimpleGrantedAuthority(usersEntity.getIsAdmin() ? "ROLE_ADMIN" : "ROLE_USER");
		grantList.add(authority);
		UserDetails userDetails = (UserDetails) new User(usersEntity.getUsersId(), usersEntity.getPassWord(), grantList);
		return userDetails;
	}

}
