package io.ashwinikb;

public class ShortUrlUtil {

	public static String hash(String url) {
		int hashcode = url.hashCode();
		return Integer.toString(hashcode);
	}

}
