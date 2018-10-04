package com.restApi.util;

import java.util.Random;

public class GenerateTinyUrl {

	private static GenerateTinyUrl generateTinyUrl;

	private GenerateTinyUrl() {
	}

	public static synchronized GenerateTinyUrl getInstance() {
		if (generateTinyUrl == null) {
			generateTinyUrl = new GenerateTinyUrl();
		}
		return generateTinyUrl;
	}

	public String generateTinyUrl(int keyLength) {
		String charVault = Constants.CHAR_VAULT;
		int N = charVault.length();
		Random rd = new Random();
		StringBuilder sb = new StringBuilder(keyLength);
		for (int i = 0; i < keyLength; i++) {
			sb.append(charVault.charAt(rd.nextInt(N)));
		}
		return sb.toString();
	}

}
