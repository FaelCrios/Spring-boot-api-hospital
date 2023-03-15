package med.vol.api.domain.patient;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.adress.AdressData;

public class PatientRegisterData {
	@NotBlank
	String nome;
	@NotBlank
	@Email
	String email;
	@NotBlank
	String rg;
	@NotBlank
	String cpf;
	
	@NotNull
	@Valid
	AdressData adress;
	
	public PatientRegisterData() {
		
	}

	public PatientRegisterData(String nome,String email ,String rg, String cpf, AdressData adress) {
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.adress = adress;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public AdressData getAdress() {
		return adress;
	}

	public void setAdress(AdressData adress) {
		this.adress = adress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientRegisterData other = (PatientRegisterData) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "PatientRegisterData [name=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", adress=" + adress + "]";
	}
	
	
}
