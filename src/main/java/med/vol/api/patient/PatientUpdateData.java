package med.vol.api.patient;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import med.vol.api.adress.AdressData;

public class PatientUpdateData {
	
	@NotNull
	private Long id;
	private String nome;
	private AdressData adress;

	public PatientUpdateData() {

	}

	public PatientUpdateData(String nome, AdressData data) {
		this.nome = nome;
		this.adress = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AdressData getAdress() {
		return adress;
	}

	public void setAdress(AdressData adress) {
		this.adress = adress;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientUpdateData other = (PatientUpdateData) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
