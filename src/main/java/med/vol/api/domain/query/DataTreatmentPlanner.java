package med.vol.api.domain.query;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.medic.Speciality;

import java.time.LocalDateTime;

public class DataTreatmentPlanner {
    private Long idMedico;

    @NotNull
    private Long idPaciente;

    @NotNull
    @Future
    private LocalDateTime data;

    private Speciality speciality;

    public DataTreatmentPlanner(Long idMedico, Long idPaciente, LocalDateTime data, Speciality speciality) {
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.data = data;
        this.speciality = speciality;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getTime() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
