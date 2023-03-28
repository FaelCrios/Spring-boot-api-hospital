package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.query.ConsultationRepository;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientWithNoOtherAppointmentValidation implements ValidationScheludeQuery{

    @Autowired
    private ConsultationRepository repository;

    public void Validation(DataTreatmentPlanner data) {
        var firstTime = data.getTime().withHour(7);
        var lastTime = data.getTime().withHour(18);
        var patientWithNoOtherAppointmentthatDay = repository.existsByPacienteIdAndDataBetween(data.getIdPaciente(), firstTime,lastTime);

        if(patientWithNoOtherAppointmentthatDay){
            throw new ValidationException("Patient already has another appointment scheduled that day");
        }
    }


    }
