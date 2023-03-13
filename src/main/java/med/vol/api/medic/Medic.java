package med.vol.api.medic;

import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import med.vol.api.adress.Adress;

@Table(name = "medicos")
@Entity(name = "medico")
public class Medic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome; 
	private String email; 
	private String crm;
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Speciality speciality;
	
	@Embedded
	private Adress adress;
	
	private Boolean ativo;
	
	public Medic() {
		
	}

	public Medic(Long id, String nome, String email,String phone,String crm, Speciality speciality, Adress adress) {
		Id = id;
		this.nome = nome;
		this.email = email;
		this.setPhone(phone);
		this.crm = crm;
		this.speciality = speciality;
		this.adress = adress;
	}

	public Medic(MedicRegisterData data) {
		this.ativo = true;
		this.nome = data.nome();
		this.email = data.email();
		this.setPhone(data.phone());
		this.crm = data.crm();
		this.speciality = data.speciality();
		this.adress = new Adress(data.adress());
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
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medic other = (Medic) obj;
		return Objects.equals(Id, other.Id);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void updateData(@Valid MedicUpdateData data) {
		if(data.getNome() != null) {
			this.nome = data.getNome();
		}
		if(data.getPhone() != null) {
			this.phone = data.getPhone();
		}
		if(data.getAdress() != null) {
			this.adress.updateData(data.getAdress());
		}
	}

	public void exclude() {
		this.ativo = false;
		
	}
	
	
	
	
}
