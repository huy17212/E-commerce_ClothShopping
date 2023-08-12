package com.HTT.company.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.HTT.company.constant.ApplicationConstant;
import com.HTT.company.entity.Users;

@Component
public class JavaGmailSenderUtils {

	@Autowired
	JavaMailSender mailSender;

	public static void sendEmailWithMultipartFile() {

	}

	public void sendEmailActivated(String AddressGmailTo, String hyperlink, Users users) throws MessagingException {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			ApplicationConstant.TRUE_TOKEN_FOR_CREATE_NEW_ACCOUNT = ApplicationConstant
					.GENERATE_RANDOM_TOKEN_FOR_CREATE_NEW_ACCOUT();

			helper.setSubject("Utora Activated Hyperlink.");
			helper.setFrom(ApplicationConstant.GMAIL_ADDRESS_COMPANY);
			helper.setTo(AddressGmailTo);
			
			System.out.println("kaka finder" + users.toString());

			String content = "<b>Gettings " + users.getUsersId() + "</b>,"
					+ "<br><i>Please click this hyberlink to activated your account:.</i>" + "<br>" + "<form action='"
				    + "https://ustora.herokuapp.com/activatedAccount?tokenCreateAccount=" + ApplicationConstant.TRUE_TOKEN_FOR_CREATE_NEW_ACCOUNT
					+ "' method='POST' >" + "<button type='submit'>Activated account!</button>" + "</form>"
					+ "<br><img src='cid:image001'/><br><b>Best Regards</b>";
			helper.setText(content, true);

			ClassPathResource imgFile = new ClassPathResource("templates/assert/img/logo.png");
			helper.addInline("image001", imgFile);

			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
