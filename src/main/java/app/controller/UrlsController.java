package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.model.Url;
import app.repository.UrlsRepository;
import app.resource.UrlResource;
import service.UrlIdService;

/**
 * URL controller
 * 
 * @author Dusan Eremic
 *
 */
@Controller
@CrossOrigin
public class UrlsController {

	@Autowired
	private UrlsRepository urlsRepository;

	@Autowired
	private UrlIdService urlIdGenerator;

	@RequestMapping(value = "/urls", method = RequestMethod.POST)
	public HttpEntity<UrlResource> shortenUrl(HttpServletRequest request, @RequestBody UrlResource urlResource) {

		final Url url = new Url();
		url.setId(String.valueOf(urlIdGenerator.getNextId()));
		url.setOriginalUrl(urlResource.getUrl());
		urlsRepository.save(url);
		final String baseUrl = request.getScheme() + "://" + request.getServerName()
				+ (request.getServerPort() == -1 ? "" : ":" + request.getServerPort());
		urlResource.setShortUrl(baseUrl + "/" + urlIdGenerator.encodeUrlId(url.getId()));

		return new HttpEntity<UrlResource>(urlResource);
	}

	@RequestMapping(value = "/{urlId}", method = RequestMethod.GET)
	public String getUrlAndRedirect(@PathVariable final String urlId) {

		String decodedUrlId = urlIdGenerator.decodeUrlId(urlId);
		final Url url = urlsRepository.findOne(decodedUrlId);

		return "redirect:" + url.getOriginalUrl();
	}

}
