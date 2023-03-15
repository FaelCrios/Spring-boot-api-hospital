package med.vol.api.domain.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.adress.AdressData;

public record MedicRegisterData(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email,
		@NotBlank
		String phone,
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		@NotNull
		Speciality speciality, 
		@NotNull
		@Valid
		AdressData adress
		) {


}