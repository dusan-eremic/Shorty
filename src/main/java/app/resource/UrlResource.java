package app.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * URL REST resource
 * 
 * @author Dusan Eremic
 *
 */
public class UrlResource extends ResourceSupport {

	private String url;

	private String shortUrl;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
