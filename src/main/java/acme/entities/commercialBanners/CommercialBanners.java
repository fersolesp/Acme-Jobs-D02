
package acme.entities.commercialBanners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.entities.banners.Banners;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanners extends Banners {
	//Serializacion identifier ------------------------------

	private static final long	serialVersionUID	= 1L;

	@CreditCardNumber
	@NotBlank
	private String				creditCard;
}
