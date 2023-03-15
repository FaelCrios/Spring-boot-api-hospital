package med.vol.api.domain.medic;

public record DataMedicList(Long id,String nome,String email,String crm,Speciality speciality) {
	
	public DataMedicList(Medic medic) {
		this(medic.getId(),medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpeciality());
	}
}
