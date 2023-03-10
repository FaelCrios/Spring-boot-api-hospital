package med.vol.api.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdressData(
		@NotBlank
		String state,
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep,
		@NotBlank
		String city, 
		@NotBlank
		String neighborhood,
		@NotBlank
		String street, 
		String numero ) {

}
