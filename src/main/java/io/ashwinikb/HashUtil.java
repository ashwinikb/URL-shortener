package io.ashwinikb;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

/**
 * @author Ashwini KB
 */
public class HashUtil {

	/**
	 * Calculates hash for long URL
	 * 
	 * @param url
	 * @return
	 */
	public static String hash(String url) {
		return Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
	}

}
