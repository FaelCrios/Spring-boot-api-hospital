package med.vol.api.domain.query;

import jakarta.validation.ValidationException;
import med.vol.api.domain.medic.Medic;
import med.vol.api.domain.medic.MedicRepository;
import med.vol.api.domain.patient.PatientRepository;
import med.vol.api.domain.query.validation.ValidationScheludeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationSchedule {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private List<ValidationScheludeQuery> validation;


    public DataTreatmentDetails schedule(DataTreatmentPlanner data){
        if(!patientRepository.existsById(data.getIdPaciente())){
            throw new ValidationException("Patient Id doesnt exist");
        }
        if(data.getIdMedico() != null && !medicRepository.existsById(data.getIdMedico())){
            throw new ValidationException("Medic Id doesnt exist");
        }

        validation.forEach(v -> v.Validation(data));


        var patient = patientRepository.getReferenceById(data.getIdPaciente());
        var medic = chooseMedic(data);
        var treatment = new Treatment(null, medic, patient, data.getTime());
        consultationRepository.save(treatment);
        return new DataTreatmentDetails(treatment);
    }

    private Medic chooseMedic(DataTreatmentPlanner data) {
        if(data.getIdMedico() != null){
            return medicRepository.getReferenceById(data.getIdMedico());
        }
        if(data.getSpeciality() == null){
            throw new ValidationException("specialty is required when physician is not specified");
        }
        return medicRepository.chooseRandomMedic(data.getSpeciality(), data.getTime());
    }
}
