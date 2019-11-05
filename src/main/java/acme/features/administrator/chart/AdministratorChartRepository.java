
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select count(c) FROM CompanyRecord c group by c.sector")
	Object[] findTotalNumberOfCompaniesBySector();

	@Query("select count(i) FROM InvestorRecords i group by i.workSector")
	Object[] findTotalNumberOfInvestorsBySector();

	@Query("select c.sector FROM CompanyRecord c group by c.sector")
	Object[] findCompanySector();

	@Query("select i.workSector FROM InvestorRecords i group by i.workSector")
	Object[] findInvestorSector();
}
