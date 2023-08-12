package com.HTT.company.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HTT.company.entity.Users;
import com.HTT.company.service.UsersService;
import com.HTT.company.util.FacebookDtoUtils;
import com.HTT.company.util.GoogleDtoUtils;
import com.HTT.company.util.JavaLoginWithFacebookUtils;
import com.restfb.types.User;

@Controller
public class FacebookServiceController {

	@Autowired
	JavaLoginWithFacebookUtils facebookUtils;

	@Autowired
	UsersService usersService;

	@Autowired
	JavaLoginWithFacebookUtils faceUtil;

	@GetMapping("LoginWithFacebook")
	public String loginWithGoogle(HttpServletRequest request, @RequestParam("code") String codeToken, Principal print)
			throws ClientProtocolException, IOException {

		String accessToken = facebookUtils.getToken(codeToken);
		User user = facebookUtils.getUserInfo(accessToken);

//		// create principal
		UserDetails userDetail = faceUtil.buildUser(user);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());

		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// check the duplicated in database, if true -> create new account, nor login
		// with that account.
		Optional<Users> userTemporaty = Optional.ofNullable(usersService.findByUserName(user.getId()));

		if (userTemporaty.isEmpty()) {
			Users parsingUserEntity = FacebookDtoUtils.FacebookDtoParseToUsers(user);
			usersService.create(parsingUserEntity);
		} else {
			return "redirect:/loginsuccessful";
		}
		return "redirect:/loginsuccessful";
	}
}
