package com.hunqin.demo;

import java.util.UUID;

public class CodeUtil {
	public static String generateUniqueCode(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
