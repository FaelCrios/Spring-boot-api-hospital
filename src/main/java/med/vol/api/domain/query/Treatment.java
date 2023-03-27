package med.vol.api.domain.query;

import jakarta.persistence.*;
import med.vol.api.domain.medic.Medic;
import med.vol.api.domain.patient.Patient;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "consultas")
@Entity(name="Consulta")
public class Treatment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medic medic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Patient patient;
    private LocalDateTime data;

    public Treatment() {
    }

    public Treatment(Long id, Medic medic, Patient patient, LocalDateTime data) {
        this.id = id;
        this.medic = medic;
        this.patient = patient;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return id.equals(treatment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
