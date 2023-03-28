package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.patient.PatientRepository;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidation implements ValidationScheludeQuery {

    @Autowired
    private PatientRepository repository;

    public void Validation(DataTreatmentPlanner data) {
        var patientIsActive = repository.findAtivoById(data.getIdPaciente());
        if(!patientIsActive){
            throw new ValidationException("An appointment must be scheduled with an active patient");
        }
    }
}
