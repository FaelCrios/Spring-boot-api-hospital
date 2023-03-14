package med.vol.api.medic;

import med.vol.api.adress.Adress;

public record MedicDataDetails(Long id, String nome, String email, String crm, Speciality speciality, Adress adress) {

	
	public MedicDataDetails(Medic medic) {
		this(medic.getId(), medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpeciality(), medic.getAdress());
	}
}
