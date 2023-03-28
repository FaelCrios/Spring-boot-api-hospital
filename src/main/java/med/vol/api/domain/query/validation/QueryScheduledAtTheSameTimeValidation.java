package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.query.ConsultationRepository;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryScheduledAtTheSameTimeValidation implements ValidationScheludeQuery{

    @Autowired
    private ConsultationRepository repository;
    public void Validation(DataTreatmentPlanner data) {
            var medicHaveAnotherQueryInThatMoment = repository.existsByMedicoIdAndData(data.getIdMedico(), data.getTime());
            if(medicHaveAnotherQueryInThatMoment){
                throw new ValidationException("This doctor already has another appointment at this time");
            }
    }
}