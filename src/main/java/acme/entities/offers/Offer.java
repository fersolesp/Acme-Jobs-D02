
package acme.entities.offers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "(O)([a-zA-Z]{4})(-)([0-9]{5})")
	@Column(unique = true)
	private String				ticker;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;

	@NotBlank
	private String				description;

	private Money				money;
}