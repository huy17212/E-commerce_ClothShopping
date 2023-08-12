package com.HTT.company.util;

import com.HTT.company.constant.ApplicationConstant;
import com.HTT.company.dto.FacebookDto;
import com.HTT.company.dto.GoogleDto;
import com.HTT.company.entity.Users;
import com.restfb.types.User;

public class FacebookDtoUtils {

	public static Users FacebookDtoParseToUsers(User entityFacebookDto) {

		Users entityUsers = (Users) ApplicationConstant.APPLICATION_CONTEXT.getBean("getUsers");
		entityUsers.setUsersId(entityFacebookDto.getId());
		entityUsers.setPassWord("");
		entityUsers.setAccountName(entityFacebookDto.getName());
		entityUsers.setNumberPhone("");
		entityUsers.setGmail(entityFacebookDto.getEmail());
		entityUsers.setAvatar(entityFacebookDto.getFirstName());
		System.out.println("kakafinder " + entityFacebookDto);
		return entityUsers;
	}

}
