package med.vol.api.patient;

import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import med.vol.api.adress.Adress;
@Table(name="pacientes")
@Entity(name = "pacientes")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String email;
	private String rg;
	private String cpf;
	
	@Embedded
	private Adress adress;
	
	public Patient() {
		
	}

	public Patient(Long id,String nome, String email, String rg, String cpf, Adress adress) {
		Id = id;
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.adress = adress;
	}
	
	public Patient(PatientRegisterData data) {
		this.nome = data.getNome();
		this.email = data.getEmail();
		this.rg = data.getRg();
		this.cpf = data.getCpf();
		this.adress = new Adress(data.getAdress());
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome= nome;
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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
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
		Patient other = (Patient) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
	
}
