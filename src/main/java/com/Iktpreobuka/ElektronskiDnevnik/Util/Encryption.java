package com.Iktpreobuka.ElektronskiDnevnik.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
	public static String getEncodedPassword(String password) {
		BCryptPasswordEncoder bce = new BCryptPasswordEncoder();
		return bce.encode(password);
				
	}
	public static boolean validatePassword(String password, String encodedPassword) {
		BCryptPasswordEncoder bce = new BCryptPasswordEncoder();
		String replecedEncodedPassword = encodedPassword.replace("{bcrypt}", "");
		return bce.matches(password, replecedEncodedPassword);
		
	}
	public static void main(String[] args) {
		System.out.println(getEncodedPassword("vladimir"));
		System.out.println(validatePassword("vladimir","$2a$10$CxbCdlxIDnfX2CQqaYPeyuTZqvqvmKd7kFc15BR5ARaIEqQGLR56G"));
	}
}
