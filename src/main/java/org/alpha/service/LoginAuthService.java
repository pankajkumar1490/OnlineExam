package org.alpha.service;

import javax.inject.Inject;
import org.alpha.repository.LoginRepository;
import org.alpha.service.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;;
/**
 * Service class for managing sites.
 */
@Service
@Transactional
public class LoginAuthService {
	@Inject
	private LoginRepository loginRepository;
	private final Logger log = LoggerFactory.getLogger(LoginAuthService.class);

	
	
	
	public int validateUser(LoginDTO loginDTO) {
		int numberOfuser=0;
		String id="";
		try{			
			numberOfuser = loginRepository.countByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		}
		catch(Exception e){
		}
     return numberOfuser;
	}
	
	
	/*public SiteDTO createSite(SiteDTO siteDTO) {
		try{
			
			int numberOfSitesWithSameSiteId = siteRepository.countBySiteIdAndRecordStatusNot(siteDTO.getSiteId(), MiscConstants.RECORD_STATUS_DELETED);
			List<Site> attachedSites = new ArrayList<>();
			if(numberOfSitesWithSameSiteId == 0) {
				Site newSite = new Site();
				
				newSite.setSiteName(siteDTO.getSiteName());
				newSite.setSiteId(siteDTO.getSiteId());
				newSite.setSiteType(siteDTO.getSiteType());
				newSite.setEkpNumber(siteDTO.getEkpNumber());
				newSite.setSiteIpAddress(siteDTO.getSiteIpAddress());
				newSite.setFtpUserName(siteDTO.getFtpUserName());
				newSite.setFtpPasswrod(siteDTO.getFtpPasswrod());
				newSite.setFtpkisImportPath(siteDTO.getFtpkisImportPath());
				newSite.setFtpPathDrop(siteDTO.getFtpPathDrop());
				newSite.setKisImportWsEndpoint(siteDTO.getKisImportWsEndpoint());
				newSite.setSubSite(siteDTO.getSubSite());
				newSite.setSubSitesAttached(attachedSites);
				newSite.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
				newSite = siteRepository.save(newSite);
				siteDTO.setId(newSite.getId());

				Set<String> moduleIds = new HashSet<>();
				if(siteDTO.getBaseModules() != null && siteDTO.getBaseModules().size() > 0){
					siteDTO.getBaseModules().forEach(baseModule ->{
						moduleIds.add(baseModule.getId());
					});
				}

				BaseSiteModuleConfiguration baseSiteModuleConfiguration = new BaseSiteModuleConfiguration(String.valueOf(newSite.getSiteId()) , moduleIds);
				baseSiteModuleConfiguration.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
				baseSiteModuleConfigRepository.save(baseSiteModuleConfiguration);
			}else {
				Site alreadyExistingSites = siteRepository.findBySiteIdAndSubSiteAndRecordStatusNot(siteDTO.getSiteId(), false, MiscConstants.RECORD_STATUS_DELETED);
				
				Site subSite = new Site();
				subSite.setSiteName(siteDTO.getSiteName());
				subSite.setSiteId(siteDTO.getSiteId());
				subSite.setSiteType(siteDTO.getSiteType());
				subSite.setEkpNumber(siteDTO.getEkpNumber());
				subSite.setSiteIpAddress(siteDTO.getSiteIpAddress());
				subSite.setFtpUserName(siteDTO.getFtpUserName());
				subSite.setFtpPasswrod(siteDTO.getFtpPasswrod());
				subSite.setFtpkisImportPath(siteDTO.getFtpkisImportPath());
				subSite.setFtpPathDrop(siteDTO.getFtpPathDrop());
				subSite.setKisImportWsEndpoint(siteDTO.getKisImportWsEndpoint());
				subSite.setSubSite(siteDTO.getSubSite());
				subSite.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
				attachedSites.add(subSite);
				alreadyExistingSites.setSubSitesAttached(attachedSites);
				siteRepository.save(alreadyExistingSites);
				
//				subSite = siteRepository.save(subSite);
//				siteDTO.setId(subSite.getId());
//
//				Set<String> moduleIds = new HashSet<>();
//				if(siteDTO.getBaseModules() != null && siteDTO.getBaseModules().size() > 0){
//					siteDTO.getBaseModules().forEach(baseModule ->{
//						moduleIds.add(baseModule.getId());
//					});
//				}
//
//				BaseSiteModuleConfiguration baseSiteModuleConfiguration = new BaseSiteModuleConfiguration(String.valueOf(newSite.getSiteId()) , moduleIds);
//				baseSiteModuleConfiguration.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
//				baseSiteModuleConfigRepository.save(baseSiteModuleConfiguration);
//				
				
				
			}
			
			

			log.debug("Created Information for Site: {}");

		}catch(Exception e){

			log.debug("Exception while createSite "+ e.getMessage());

		}
		return siteDTO;
	}

	public void addUser(AddUserDTO addUserDTO) {
		try{
			
			//int numberOfSitesWithSameSiteId = siteRepository.countBySiteIdAndRecordStatusNot(siteDTO.getSiteId(), MiscConstants.RECORD_STATUS_DELETED);
			//List<Site> attachedSites = new ArrayList<>();
			//if(numberOfSitesWithSameSiteId == 0) {
				//Testdomain newSite = new Testdomain();
			AddUserDomain newUser = new AddUserDomain();
			newUser.setuName(addUserDTO.getuName());	
			newUser.setcNumber(addUserDTO.getcNumber());	
			newUser.setsName(addUserDTO.getsName());	
				//newSite.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
			demoRepository.save(newUser);
		}
		catch(Exception e){
			
		}

	}
	
	public void addSelectedUser(AddSelectedUserDTO addSelectedUserDTO) {
		try{
			
			//int numberOfSitesWithSameSiteId = siteRepository.countBySiteIdAndRecordStatusNot(siteDTO.getSiteId(), MiscConstants.RECORD_STATUS_DELETED);
			//List<Site> attachedSites = new ArrayList<>();
			//if(numberOfSitesWithSameSiteId == 0) {
				//Testdomain newSite = new Testdomain();
			AddSelectedUserDomain newUser = new AddSelectedUserDomain();
			newUser.setUserName(addSelectedUserDTO.getUserName());	
				
				//newSite.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
			demoSelectedRepository.save(newUser);
		}
		catch(Exception e){
			
		}

	}
	
	
	public List<AddUserDTO> getUser() {
		List<AddUserDomain> newUser = new ArrayList<>();
		newUser = demoRepository.findAll();
		List<AddUserDTO> dtos = new ArrayList<AddUserDTO>();
		for (AddUserDomain user : newUser) {
			AddUserDTO addUserDTO = new AddUserDTO();
			addUserDTO.setcNumber(user.getcNumber());
			addUserDTO.setuName(user.getuName());
			addUserDTO.setsName(user.getsName());
			dtos.add(addUserDTO);
		}
		return dtos;

	}
	
	
	public List<ExamQuestionDTO> getAllQuestions() {
		List<ExamQuestionDomain> newQuestions = new ArrayList<>();
		newQuestions = examQuestionRepository.findAll();
		List<ExamQuestionDTO> dtos = new ArrayList<ExamQuestionDTO>();
		for (ExamQuestionDomain question : newQuestions) {
			ExamQuestionDTO addQuestionDTO = new ExamQuestionDTO();
			addQuestionDTO.setId(question.getId());
			addQuestionDTO.setQ_no(question.getQ_no());
			addQuestionDTO.setQ_type(question.getQ_type());
			addQuestionDTO.setQ_detail(question.getQ_detail());
			addQuestionDTO.setQ_op1(question.getQ_op1());
			addQuestionDTO.setQ_op2(question.getQ_op2());
			addQuestionDTO.setQ_op3(question.getQ_op3());
			addQuestionDTO.setQ_op4(question.getQ_op4());
			addQuestionDTO.setQ_answer(question.getQ_answer());
			dtos.add(addQuestionDTO);
		}
		return dtos;

	}
	
	
	public SiteDTO updateSite(SiteDTO siteDTO) {
		log.info("request to update site : {}", siteDTO);
		Site site = siteRepository.findOne(siteDTO.getId());
		
		if(siteDTO.getSubSite()) {
			for(Site s:site.getSubSitesAttached()) {
				List<Site> sList = new ArrayList<>();
				s.setId(siteDTO.getId());
				s.setSiteName(siteDTO.getSiteName());
				s.setSiteIpAddress(siteDTO.getSiteIpAddress());
				s.setSiteId(siteDTO.getSiteId());
				s.setSiteType(siteDTO.getSiteType());
				s.setEkpNumber(siteDTO.getEkpNumber());
				s.setFtpPasswrod(siteDTO.getFtpPasswrod());
				s.setFtpUserName(siteDTO.getFtpUserName());
				s.setFtpkisImportPath(siteDTO.getFtpkisImportPath());
				s.setFtpPathDrop(siteDTO.getFtpPathDrop());
				s.setKisImportWsEndpoint(siteDTO.getKisImportWsEndpoint());
				s.setSubSite(siteDTO.getSubSite());
				s.setRecordStatus(MiscConstants.RECORD_STATUS_UPDATED);
				sList.add(s);
				site.setSubSitesAttached(sList);
			}
			
			siteRepository.save(site);
		}else {
			site.setId(siteDTO.getId());
			site.setSiteName(siteDTO.getSiteName());
			site.setSiteIpAddress(siteDTO.getSiteIpAddress());
			site.setSiteId(siteDTO.getSiteId());
			site.setSiteType(siteDTO.getSiteType());
			site.setEkpNumber(siteDTO.getEkpNumber());
			
			if(site.getSubSitesAttached()!=null && site.getSubSitesAttached().size() > 0) {
				site.getSubSitesAttached().get(0).setEkpNumber(siteDTO.getEkpNumber());
			}
			
			site.setFtpPasswrod(siteDTO.getFtpPasswrod());
			site.setFtpUserName(siteDTO.getFtpUserName());
			site.setFtpkisImportPath(siteDTO.getFtpkisImportPath());
			site.setFtpPathDrop(siteDTO.getFtpPathDrop());
			site.setKisImportWsEndpoint(siteDTO.getKisImportWsEndpoint());
			site.setSubSite(siteDTO.getSubSite());
			site.setRecordStatus(MiscConstants.RECORD_STATUS_UPDATED);
			Site siteUpdated  = siteRepository.save(site);
			
			Set<String> moduleIds = new HashSet<>();
			if(siteDTO.getBaseModules() != null && siteDTO.getBaseModules().size() > 0){
				siteDTO.getBaseModules().forEach(baseModule ->{
					moduleIds.add(baseModule.getId());
				});
			}
			
			BaseSiteModuleConfiguration baseSiteModuleConfiguration = baseSiteModuleConfigRepository.findOneBySiteId(String.valueOf(siteDTO.getSiteId()));
			if(baseSiteModuleConfiguration != null) {
				baseSiteModuleConfiguration.setModuleIds(moduleIds);
				baseSiteModuleConfiguration.setRecordStatus(MiscConstants.RECORD_STATUS_UPDATED);
			}else {
				baseSiteModuleConfiguration = new BaseSiteModuleConfiguration();
				baseSiteModuleConfiguration.setSiteId(String.valueOf(siteUpdated.getSiteId()));
				baseSiteModuleConfiguration.setRecordStatus(MiscConstants.RECORD_STATUS_NEW);
				baseSiteModuleConfiguration.setModuleIds(moduleIds);
			}
			baseSiteModuleConfigRepository.save(baseSiteModuleConfiguration);
			log.info("Update Information for Site: {}", siteUpdated);
			siteDTO.setId(siteUpdated.getId());
		}
		
		return siteDTO;
	}

	public SiteDTO getSite( String id){
		log.info("getSite::: {}");
		Site site = siteRepository.findOne(id);
		
		SiteDTO dto = new SiteDTO();
		dto.setId(site.getId());
		dto.setSiteName(site.getSiteName());
		dto.setSiteIpAddress(site.getSiteIpAddress());
		dto.setSiteId(site.getSiteId());
		dto.setSiteType(site.getSiteType());
		dto.setEkpNumber(site.getEkpNumber());
		dto.setFtpPasswrod(site.getFtpPasswrod());
		dto.setFtpUserName(site.getFtpUserName());
		dto.setFtpkisImportPath(site.getFtpkisImportPath());
		dto.setFtpPathDrop(site.getFtpPathDrop());
		dto.setKisImportWsEndpoint(site.getKisImportWsEndpoint());
		dto.setSubSite(site.getSubSite());
		dto.setSubSitesAttached(site.getSubSitesAttached());
		//BaseSiteModuleConfiguration baseModuleConfig = baseSiteModuleConfigRepository.findOneBySiteId(String.valueOf(site.getSiteId()));
		//BaseSiteModuleConfigurationDTO moduleDto = new BaseSiteModuleConfigurationDTO();
		//if(baseModuleConfig != null)
			//BeanUtils.copyProperties(baseModuleConfig, moduleDto);
		//dto.setBaseSiteModuleConfigurationDTO(moduleDto);
		Set<String> moduleIds = new HashSet<>();
		HashMap<String, String> licMap = userService.getLicenseData();
		 if (!licMap.isEmpty()) {
			 for (Entry<String, String> entry : licMap.entrySet()) {
				log.info("CustomSignedFeatures KEY::"+entry.getKey());
				if(entry.getKey().contains(String.valueOf(site.getSiteId()))) {
					
					if(entry.getValue() !=null && entry.getValue().trim().equalsIgnoreCase("true")) {
						moduleIds.add(entry.getKey().split("_")[1]);
					}
					
				}
			 }
			 BaseSiteModuleConfigurationDTO ob = new BaseSiteModuleConfigurationDTO();
				ob.setModuleIds(moduleIds);
				ob.setSiteId(String.valueOf(site.getSiteId()));
			    dto.setBaseSiteModuleConfigurationDTO(ob);
		 }

		 
		return dto;
	}

	public void kisImportSave(){

	}
	*//**
	 * Get All Light Weight Sites For Auto-Complete   
	 * 
	 *//*
	public List<SiteDTO> getLightWeightSites() {
		List<SiteDTO>  siteDTOs = new ArrayList<>();
		List<Site> list = siteRepository.findByRecordStatusNot(MiscConstants.RECORD_STATUS_DELETED);
		if(!list.isEmpty() && list.size() > 0){
			list.forEach(site ->{
				SiteDTO dto = new SiteDTO();
				dto.setId(site.getId());;
				dto.setSiteId(site.getSiteId());
				dto.setSiteName(site.getSiteName());
				dto.setSubSite(site.getSubSite());
				dto.setSiteType(site.getSiteType());
				siteDTOs.add(dto);
			});
		}
		return siteDTOs;
	}

	public SiteDTO getSubSite(int siteId) {

		log.info("get Sub Site of ::: {}" , siteId);
		Site site = siteRepository.findBySiteIdAndSubSiteAndRecordStatusNot(siteId, true, MiscConstants.RECORD_STATUS_DELETED);
		SiteDTO dto = null;
		if(site != null) {
			dto =  new SiteDTO();
			dto.setId(site.getId());
			dto.setSiteName(site.getSiteName());
			dto.setSiteIpAddress(site.getSiteIpAddress());
			dto.setSiteId(site.getSiteId());
			dto.setSiteType(site.getSiteType());
			dto.setEkpNumber(site.getEkpNumber());
			dto.setFtpPasswrod(site.getFtpPasswrod());
			dto.setFtpUserName(site.getFtpUserName());
			dto.setFtpkisImportPath(site.getFtpkisImportPath());
			dto.setFtpPathDrop(site.getFtpPathDrop());
			dto.setKisImportWsEndpoint(site.getKisImportWsEndpoint());
			dto.setSubSite(site.getSubSite());
			dto.setSubSiteAvailable(true);
			BaseSiteModuleConfiguration baseModuleConfig = baseSiteModuleConfigRepository.findOneBySiteId(String.valueOf(site.getSiteId()));
			BaseSiteModuleConfigurationDTO moduleDto = new BaseSiteModuleConfigurationDTO();
			if(baseModuleConfig != null)
				BeanUtils.copyProperties(baseModuleConfig, moduleDto);
			dto.setBaseSiteModuleConfigurationDTO(moduleDto);
		}else {
			dto =  new SiteDTO();
			dto.setSubSiteAvailable(false);
		}
		return dto;
	}

	public List<SiteDTO> getSiteAndSubSite() {
		List<SiteDTO>  siteDTOs = new ArrayList<>();
		List<Site> list = siteRepository.findByRecordStatusNot(MiscConstants.RECORD_STATUS_DELETED);
		if(!list.isEmpty() && list.size() > 0){
			for(Site site : list){
				if(site.getSiteType().equalsIgnoreCase("NS")) {
				SiteDTO mainSite = new SiteDTO();
				mainSite.setId(site.getId());
				mainSite.setSiteName(site.getSiteName());
				
				if(site.getSiteId() == 313 || site.getSiteId() == 314 || site.getSiteId() == 318)
					mainSite.setSiteId(Integer.valueOf(String.valueOf(site.getSiteId())+"01"));
				else
					mainSite.setSiteId(site.getSiteId());

				siteDTOs.add(mainSite);

				if(site.getSiteId() == 313 || site.getSiteId() == 314 || site.getSiteId() == 318){
					if(site.getSubSitesAttached() !=null && !site.getSubSitesAttached().isEmpty() && site.getSubSitesAttached().size()>0){
						for(Site sbSite : site.getSubSitesAttached()){
							SiteDTO subSite = new SiteDTO();
							subSite.setId(sbSite.getId());
							subSite.setSiteName(sbSite.getSiteName());
							subSite.setSiteId(Integer.valueOf(String.valueOf(sbSite.getSiteId())+"02"));
							siteDTOs.add(subSite);
						}
					}
				}
			}
		}
		}
		return siteDTOs;
	}*/
}
