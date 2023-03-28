package med.vol.api.domain.query;

import java.time.LocalDateTime;
import java.util.Objects;

public class DataTreatmentDetails {

    private Long id;
    private Long idMedico;
    private Long idPatiente;
    private LocalDateTime data;

    public DataTreatmentDetails(){}

    public DataTreatmentDetails(Long id, Long idMedico, Long idPatient, LocalDateTime data){
        this.id = id;
        this.idMedico = idMedico;
        this.idPatiente = idPatient;
        this.data = data;
    }

    public DataTreatmentDetails(Treatment treatment) {
        this.id = treatment.getId();
        this.idMedico = treatment.getMedic().getId();
        this.idPatiente = treatment.getPatient().getId();
        this.data = treatment.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPatiente() {
        return idPatiente;
    }

    public void setIdPatiente(Long idPatiente) {
        this.idPatiente = idPatiente;
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
        DataTreatmentDetails that = (DataTreatmentDetails) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
