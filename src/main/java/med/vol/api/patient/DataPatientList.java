package med.vol.api.patient;



public class DataPatientList {
	private String nome;
	private String email;
	private String rg;
	
	DataPatientList(){
	}
	
	

	public DataPatientList(String nome, String email, String rg) {
		super();
		this.nome = nome;
		this.email = email;
		this.rg = rg;
	}

	public DataPatientList(Patient patient) {
		this.nome = patient.getName();
		this.email = patient.getEmail();
		this.rg = patient.getRg();
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
	
	


}
