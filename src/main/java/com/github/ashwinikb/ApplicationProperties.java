package com.github.ashwinikb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Ashwini KB
 */

@Component
public class ApplicationProperties {

	@Value("${app.baseURI}")
	public String baseURI;

}
