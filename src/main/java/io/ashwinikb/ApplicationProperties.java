package io.ashwinikb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${app.baseURI}")
    public String baseURI;
	
}
