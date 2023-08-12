package com.HTT.company.constant;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

public class GoogleDriveTokenConstant {

	public static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
	
	public static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	public static final String TOKENS_DIRECTORY_PATH = "tokens";
	
	public static final List<String> SCOPES = Collections.singletonList("https://www.googleapis.com/auth/drive");
	
	public static final String CREDENTIALS_FILE_PATH = "/client_secret.json";
	
}
