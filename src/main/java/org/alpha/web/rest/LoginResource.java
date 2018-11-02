package org.alpha.web.rest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.alpha.service.LoginAuthService;
import org.alpha.service.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing sites.
 */
@RestController
@RequestMapping("/api")
public class LoginResource {

	private final Logger log = LoggerFactory.getLogger(LoginResource.class);

	private HttpStatus httpStatus = HttpStatus.OK;
	
	@Inject
	private LoginAuthService loginAuthService;
	

	
	/**
	 * POST  /site  : Creates a new site.
	 */
	/* @PostMapping("/site")
	 @Timed
	 public ResponseEntity<?> createSite(@RequestBody SiteDTO siteDTO) throws URISyntaxException {
		 log.debug("REST request to save Site : {}", siteDTO);

		 Locale locale = appUtil.getLocale();
		 String      msg        =  null;
		 HttpHeaders headers    = null;
		 headers	= new HttpHeaders();

		 SiteDTO site = siteService.createSite(siteDTO);
		 msg = site.getSiteName()+" : "+ZDHResourceBundle.getResourceMap(locale,ZDHExceptionConstant.MsgSuccess);

		 headers.add("responseHeaderMessage", msg);
		 return new ResponseEntity<>(site, headers, httpStatus);
		 //return new ResponseEntity<>(site, HttpStatus.OK);
	 }
	*/
	 @PostMapping("/loginAuth")
	 @Timed
	 public ResponseEntity<?> createSite(@RequestBody LoginDTO loginDTO) throws URISyntaxException {
		 log.debug("REST request to save Site : {}", loginDTO);
         int count=0;
		// Locale locale = appUtil.getLocale();
		 String      msg        =  null;
		 HttpHeaders headers    = null;
		 headers	= new HttpHeaders();

		 count = loginAuthService.validateUser(loginDTO);
		// msg = site.getSiteName()+" : "+ZDHResourceBundle.getResourceMap(locale,ZDHExceptionConstant.MsgSuccess);

		 headers.add("responseHeaderMessage", msg);
		 return new ResponseEntity<>(loginDTO, headers, httpStatus);
		 //return new ResponseEntity<>(site, HttpStatus.OK);
	 }
	
	/* 
	 @RequestMapping(value ="/showuser",
	                method   = RequestMethod.GET,
	                produces = MediaType.APPLICATION_JSON_VALUE)
       @Timed
       @Transactional(readOnly = true)
	 public ResponseEntity<?> showUser()  {
		 
		 Locale locale = appUtil.getLocale();
		 String      msg        =  null;
		 HttpHeaders headers    = null;
		 headers	= new HttpHeaders();
		 
		 List<AddUserDTO>  addUserDTOs = siteService.getUser();

		 headers.add("responseHeaderMessage", msg);
		 return new ResponseEntity<>(addUserDTOs, headers, httpStatus);
		 //return new ResponseEntity<>(site, HttpStatus.OK);
	 } */
	 
	

/*
	 *//**
	  * this method use for update record
	  * @param siteDTO
	  * @return the ResponseEntity with status 200 (OK)
	  * @throws URISyntaxException
	  *//*

	 @RequestMapping(value = "/site",
			 method = RequestMethod.PUT,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	 @Timed
	 public  ResponseEntity<SiteDTO> updateSite(@RequestBody SiteDTO siteDTO) throws URISyntaxException {
		 log.debug("REST request to update site : {}", siteDTO);

		 Locale locale = appUtil.getLocale();
		 String      msg        =  null;
		 HttpHeaders headers    = null;
		 headers	= new HttpHeaders();

		 SiteDTO result = siteService.updateSite(siteDTO);

		 msg = result.getSiteName()+" : "+ZDHResourceBundle.getResourceMap(locale,ZDHExceptionConstant.MsgSuccessUpdate);
		 headers.add("responseHeaderMessage", msg);
		 return new ResponseEntity<>(result, headers, httpStatus);


		 //return new ResponseEntity<>(result, HttpStatus.OK);
	 }
*/
	 /**
	  * DELETE  /sites/:id : delete the "id" site.
	  *
	  * @param id the id of the SiteDTO to delete
	  * @return the ResponseEntity with status 200 (OK)
	  *//*
	 @RequestMapping(value = "/site/{id}",
			 method = RequestMethod.DELETE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	 @Timed
	 public ResponseEntity<Void> deleteSite(@PathVariable String id) {
		 log.debug("REST request to delete site : {}", id);
		 Site site = siteRepository.findOne(id);
		 site.setRecordStatus(MiscConstants.RECORD_STATUS_DELETED);
		 siteRepository.save(site);
		 return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("Site", id.toString())).build();
	 }*/

	 

}
