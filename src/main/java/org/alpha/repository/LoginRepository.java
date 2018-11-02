package org.alpha.repository;

import java.util.List;
import java.util.Set;

import org.alpha.domain.LoginDomain;
import org.alpha.service.dto.LoginDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Spring Data JPA repository for the Site entity.
 */
public interface LoginRepository extends MongoRepository<LoginDomain, String> {

	int countByUsernameAndPassword(String uname,String  pwd);
	
	
	/*Site findBySiteId(int site);

	int countBySiteNameIgnoreCase(String siteName);

	Site findBySiteNameIgnoreCase(String siteName);

	int countBySiteId(int siteId);

	int countBySiteIpAddress(String siteName);
	List<Site> findBySiteIpAddress(String siteName);

	List<Site> findByIdIn(Set<String> siteIds);

	Site findOneById(String siteId);

	Page<Site> findByIdIn(Set<String> siteIds, Pageable pageable);

	Page<Site> findByRecordStatusNot(Pageable pageable, int recordStatusDeleted);

	List<Site> findByRecordStatusNot(int recordStatusDeleted);

	List<Site> findByRecordStatusNot(Set<String> siteIds, int recordStatusDeleted);

	Page<Site> findByIdInAndRecordStatusNot(Set<String> siteIds, Pageable pageable, int recordStatusDeleted);

	Page<Site> findAllByRecordStatusNot(Pageable pageable, int recordStatusDeleted);

	int countBySiteNameIgnoreCaseAndRecordStatusNot(String siteName, int recordStatusDeleted);

	List<Site> findBySiteIpAddressAndRecordStatusNot(String siteName, int recordStatusDeleted);

	int countBySiteIdAndRecordStatusNot(int parseInt, int recordStatusDeleted);

	List<Site> findByIdInAndRecordStatusNot(Set<String> siteIds, int recordStatusDeleted);

	Site findOneByIdAndRecordStatusNot(String siteId, int recordStatusDeleted);

	List<Site> findAllBySiteIdIn(List<Integer> userSiteIdsForSiteList);

	Page<Site> findBySiteNameStartsWithIgnoreCaseAndRecordStatusNotOrSiteIpAddressStartsWithAndRecordStatusNotOrSiteIdAndRecordStatusNot(
			String searchValue, int recordStatusDeleted, String searchValue2, int recordStatusDeleted2, Integer siteId,
			int recordStatusDeleted3, Pageable pageable);

	List<Site> findAllByRecordStatusNot(int recordStatusDeleted);

	List<Site> findAllBySiteIdInAndRecordStatusNot(List<Integer> userSiteIdsForSiteList, int recordStatusDeleted);

	Site findBySiteIdAndSubSiteAndRecordStatusNot(int siteId, boolean b, int recordStatusDeleted);

	List<Site> findBySiteIdAndRecordStatusNot(int siteId, int recordStatusDeleted);

	List<Site> findAllBySiteTypeAndRecordStatusNot(String string, int recordStatusDeleted);

	Site findOneBySiteIdAndRecordStatusNot(int i, int recordStatusDeleted);

	Page<Site> findAllByRecordStatusNotOrderBySiteNameAsc(Pageable pageable, int recordStatusDeleted);

	Page<Site> findByIdInAndRecordStatusNotOrderBySiteNameAsc(Set<String> siteIds, Pageable pageable,
			int recordStatusDeleted);
	Site findOneBySiteNameIgnoreCase(String siteName);

	void save(AddUserDomain newUser);

	*/
}
