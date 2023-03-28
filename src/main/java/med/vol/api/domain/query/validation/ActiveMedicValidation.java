package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.medic.MedicRepository;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMedicValidation implements ValidationScheludeQuery {


    @Autowired
    private MedicRepository repository;


    public void Validation(DataTreatmentPlanner data){
        if(data.getIdMedico() == null){return;}
        var medicIsActive = repository.findAtivoById(data.getIdMedico());
        if(!medicIsActive){
            throw new ValidationException("Query must be scheduled with an active medic");
        }
    }
}
