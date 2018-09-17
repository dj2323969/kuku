package com.hunqin.demo;

import java.util.Random;
public class rand {
	public static String random() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<5;i++) {
			if(random.nextInt(2)==1) {
				builder.append((char)('a'+random.nextInt(26)));
			}else {
				builder.append((char)('A'+random.nextInt(26)));
			}
		}
		return builder.toString().toUpperCase();
	}
  
}
