
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("SELECT count(a.id) FROM Announcement a")
	Integer findTotalNumberOfAnnouncements();

	@Query("SELECT count(a.id) FROM CompanyRecord a")
	Integer findTotalNumberOfCompanyRecords();

	@Query("SELECT count(a.id) FROM InvestorRecords a")
	Integer findTotalNumberOfInvestorRecords();

	@Query("SELECT max(a.reward.amount) FROM Request a where a.deadline > current_date()")
	Object[] findMaxRewardOfActiveRequests();

	@Query("SELECT min(a.reward.amount) FROM Request a where a.deadline > current_date()")
	Object[] findMinRewardOfActiveRequests();

	@Query("SELECT avg(a.reward.amount) FROM Request a where a.deadline > current_date()")
	Object[] findAvgRewardOfActiveRequests();

	@Query("SELECT stddev(a.reward.amount) FROM Request a where a.deadline > current_date()")
	Object[] findStandardDeviationRewardOfActiveRequests();

	@Query("SELECT max((a.maxReward.amount + a.minReward.amount)/2) FROM Offer a where a.deadline > current_date()")
	Object[] findMaxRewardOfActiveOffers();

	@Query("SELECT min((a.maxReward.amount + a.minReward.amount)/2) FROM Offer a where a.deadline > current_date()")
	Object[] findMinRewardOfActiveOffers();

	@Query("SELECT avg((a.maxReward.amount + a.minReward.amount)/2) FROM Offer a where a.deadline > current_date()")
	Object[] findAvgRewardOfActiveOffers();

	@Query("SELECT stddev((a.maxReward.amount + a.minReward.amount)/2) FROM Offer a where a.deadline > current_date()")
	Object[] findStandardDeviationRewardOfActiveOffers();
}
