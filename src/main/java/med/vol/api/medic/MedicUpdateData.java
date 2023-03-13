package med.vol.api.medic;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import med.vol.api.adress.AdressData;

public class MedicUpdateData {

	@NotNull
	private Long id;
	private String nome;
	private String phone;
	private AdressData adress;
	
	public MedicUpdateData() {
	}

	public MedicUpdateData(@NotNull Long id, String nome, String phone, AdressData adress) {
		this.id = id;
		this.nome = nome;
		this.phone = phone;
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AdressData getAdress() {
		return adress;
	}

	public void setAdress(AdressData adress) {
		this.adress = adress;
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
		MedicUpdateData other = (MedicUpdateData) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
