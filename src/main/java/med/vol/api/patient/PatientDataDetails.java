package med.vol.api.patient;

import med.vol.api.adress.Adress;

public record PatientDataDetails( Long id, String nome, String email, Adress adress) {

	public PatientDataDetails(Patient patient) {
		this(patient.getId(), patient.getName(), patient.getEmail(), patient.getAdress());
	}
}
