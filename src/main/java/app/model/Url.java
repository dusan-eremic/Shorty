package app.model;

import org.springframework.data.annotation.Id;

/**
 * URL model
 * 
 * @author Dusan Eremic
 *
 */
public class Url {

	@Id
	private String id;

	private String originalUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
}
