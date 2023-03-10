package med.vol.api.medic;

public record DataMedicList(String nome,String email,String crm,Speciality speciality) {
	
	public DataMedicList(Medic medic) {
		this(medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpeciality());
	}
}
