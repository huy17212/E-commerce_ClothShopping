package com.HTT.company.controller;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.HTT.company.constant.ApplicationConstant;
import com.HTT.company.entity.Users;
import com.HTT.company.service.JavaFileDriveStogareService;
import com.HTT.company.service.JavaFileStorageService;
import com.HTT.company.service.JavaGmailSenderService;
import com.HTT.company.service.UsersService;
import com.HTT.company.util.WebUtils;
import com.google.api.services.drive.model.File;

@Controller
public class LoginController {

	private final Path root = Paths.get("C:/Users/Huy1721/Downloads");

	@Autowired
	JavaGmailSenderService gmailSenderService;

	@Autowired
	UsersService userService;

	@Autowired
	JavaFileStorageService fileStorageService;

	@Autowired
	UsersService usersService;

	@Autowired
	JavaFileDriveStogareService fileDriveService;

	@RequestMapping(value = { "/", "/welcome", "/index", "/home", "/Callback" }, method = RequestMethod.GET)
	public String welcomePage(Model model, Principal printPrincipal) {
		System.out.print("po tin " + printPrincipal);
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "views/another_view/index";
	}

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }

	@GetMapping("login")
	public String loginPage(Model model) {
		return "views/LoginForm";
	}

	@GetMapping("register")
	public String registerPage(Model model) {
		return "views/RegisterForm";
	}

	@PostMapping("/activatedAccount")
	public String activatedAccount(@RequestParam("tokenCreateAccount") String token) {
		if (!ApplicationConstant.TRUE_TOKEN_FOR_CREATE_NEW_ACCOUNT.equals(token)) {
			return "redirect:/register";
		}
		return "views/FillFullIInfomation";
	}

	@GetMapping("/activatedAccount")
	public String activatedAccount2() {
		return "views/FillFullIInfomation";
	}

	@PostMapping(value = "/createNewAccount")
	public String createNewAccountStep1(@ModelAttribute(name = "Users") Users entity, Model modelView,
			HttpSession session) {

		Users accountDuplicatedUsername = userService.findByUserName(entity.getUsersId());
		Users accountDuplicatedGmail = userService.findByUserName(entity.getGmail());

		session.setAttribute("stepOneCreateUsers", entity);

		if (accountDuplicatedUsername != null || accountDuplicatedGmail != null) {
			modelView.addAttribute("errorResponse", "Duplicated Username or Gmail. Please use correct one.");
			return "views/RegisterForm";
		}

		String hyperlink = "http://localhost:8082/activatedAccount";
		gmailSenderService.sendEmailActivated(entity.getGmail(), hyperlink, entity);
		return "views/ConfirmEmailCentidental";
	}

	@GetMapping("/sendConfirmEmailCentidentalAgain")
	public String sendConfirmEmailCentidentalAgain(HttpSession session) {
		Optional<Users> entity = Optional.ofNullable((Users) session.getAttribute("stepOneCreateUsers"));
		String hyperlink = "activatedAccount";
		gmailSenderService.sendEmailActivated(entity.get().getGmail(), hyperlink, entity.get());
		return "views/ConfirmEmailCentidental";
	}

	@PostMapping("/createNewAccount2")
	public String createNewAccountStep2(@RequestParam(name = "avatar") MultipartFile avatar,
			@RequestParam(name = "accountName") String accountName, Model modelView, HttpSession session)
			throws IOException {
		Optional<Users> userEntity = Optional.ofNullable((Users) session.getAttribute("stepOneCreateUsers"));

		// Save multipart file avatar to the uploads folder.
		fileStorageService.save(avatar);

		// Create new Folder in ggdrive and upload image to that, which is store and
		// use.
		File FileAvatar = fileDriveService.addNewAvatarToNewFolder(userEntity.get().getUsersId(),
				avatar.getOriginalFilename(), userEntity.get().getGmail());

		// Add permission for the account. Only admin and the guy who upload the image
		fileDriveService.addPermission(userEntity.get().getGmail(), FileAvatar);

		// Delete all image avatar to clear the uploads file
		fileStorageService.deleteAll();

		// Hash password by BcryptEncoder 10 digit
		String newHashedPassword = BCrypt.hashpw(userEntity.get().getPassWord(), BCrypt.gensalt());

		// Create new Account
		userEntity.get().setAccountName(accountName);
		userEntity.get().setPassWord(newHashedPassword);
		userEntity.get().setAvatar("https://drive.google.com/uc?id=" + FileAvatar.getId());

		usersService.create(userEntity.get());

		System.out.println(userEntity.get().toString());
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "redirect:/index";
	}

	@RequestMapping(value = "/loginsuccessful", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal, HttpSession session) {

		// Sau khi user login thanh cong se co
		String userName = principal.getName();

		System.out.println("User Name: " + userName);
		System.out.println("principal " + principal);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		session.setAttribute(ApplicationConstant.USER_ACCOUNT, loginedUser);

		return "redirect:/index";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}
		return "403Page";
	}

}