package med.vol.api.adress;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {
	private String state;
	private String cep; 
	private String city; 
	private String neighborhood;
	private String street; 
	private String numero;
	
	public Adress() {
		
	}

	public Adress(String state, String cep, String city, String neighborhood, String street, String numero) {
		this.state = state;
		this.cep = cep;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.numero= numero;
	}
	
	public Adress(AdressData data) {
		this.state = data.state();
		this.cep = data.cep();
		this.city = data.city();
		this.neighborhood = data.neighborhood();
		this.street = data.street();
		this.numero = data.numero();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return numero;
	}

	public void setNumber(String numero) {
		this.numero= numero;
	}

	public void updateData(AdressData data) {
		if (data.state() != null) {
            this.state = data.state();
        }
        if (data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if (data.cep() != null) {
            this.cep = data.cep();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.numero() != null) {
            this.numero = data.numero();
        }

	}

	
	
	
}
