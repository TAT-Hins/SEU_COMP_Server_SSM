package com.seu.cose.seu_comp.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private static MessageDigest messageDigest;
	
	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getHashedString(String plainText)  {
		if(plainText == null){
			return null;
		}
		
		String outStr = null;
		byte[] digest = messageDigest.digest(plainText.getBytes());
		outStr = bytetoString(digest);
		return outStr;
	}

	private static String bytetoString(byte[] digest) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			
			String tempStr = (Integer.toHexString(digest[i] & 0xff));
			if (tempStr.length() == 1) {
				str.append("0");
			}
			str.append(tempStr);
		}
		return str.toString().toUpperCase();
	}
}
