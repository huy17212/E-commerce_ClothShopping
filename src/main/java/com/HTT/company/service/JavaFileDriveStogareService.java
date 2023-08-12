package com.HTT.company.service;

import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.model.File;

public interface JavaFileDriveStogareService {
	
	void uploadFile(MultipartFile file);
	
	void createNewFolderDrive(String name);
	
	File addNewAvatarToNewFolder(String username, String avatar, String gmailShared);
	
	void deleteOldAvatar(String username);
	
	void addPermission(String Gmail, File fileHasToPermission);
	
	Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException;

}
