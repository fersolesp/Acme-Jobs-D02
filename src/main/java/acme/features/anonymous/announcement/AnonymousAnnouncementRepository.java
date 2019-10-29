
package acme.features.anonymous.announcement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousAnnouncementRepository extends AbstractRepository {

	@Query("select a from Announcement a where a.id= ?1")
	Announcement findOneById(int id);

	@Query("select a from Announcement a where MONTH(a.moment)+1<MONTH(current_time())")
	Collection<Announcement> findManyAll();
}
