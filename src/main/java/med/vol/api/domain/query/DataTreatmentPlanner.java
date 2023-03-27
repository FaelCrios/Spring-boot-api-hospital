package med.vol.api.domain.query;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.medic.Speciality;

import java.time.LocalDateTime;

public class DataTreatmentPlanner {
    private Long idMedico;

    @NotNull
    private Long idPatiente;

    @NotNull
    @Future
    private LocalDateTime data;

    private Speciality speciality;

    public DataTreatmentPlanner(){};
    public DataTreatmentPlanner(Long idMedic, Long idPatient, LocalDateTime time, Speciality speciality) {
        this.idMedico = idMedic;
        this.idPatiente = idPatient;
        this.data = time;
        this.speciality = speciality;
    }

    public Long getIdMedic() {
        return idMedico;
    }

    public void setIdMedic(Long idMedic) {
        this.idMedico = idMedic;
    }

    public Long getIdPatient() {
        return idPatiente;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatiente = idPatient;
    }

    public LocalDateTime getTime() {
        return data;
    }

    public void setTime(LocalDateTime time) {
        this.data = time;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
