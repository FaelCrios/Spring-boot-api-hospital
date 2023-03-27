package med.vol.api.domain.query;

import jakarta.validation.ValidationException;
import med.vol.api.domain.medic.Medic;
import med.vol.api.domain.medic.MedicRepository;
import med.vol.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationSchedule {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private ConsultationRepository consultationRepository;
    public void schedule(DataTreatmentPlanner data){
        if(!patientRepository.existsById(data.getIdPatient())){
            throw new ValidationException("Patient Id doesnt exist");
        }
        if(data.getIdMedic() != null && !medicRepository.existsById(data.getIdMedic())){
            throw new ValidationException("Medic Id doesnt exist");
        }
        var patient = patientRepository.getReferenceById(data.getIdPatient());
        var medic = chooseMedic(data);
        var treatment = new Treatment(null, medic, patient, data.getTime());
        consultationRepository.save(treatment);
    }

    private Medic chooseMedic(DataTreatmentPlanner data) {
        if(data.getIdMedic() != null){
            return medicRepository.getReferenceById(data.getIdMedic());
        }
        if(data.getSpeciality() == null){
            throw new ValidationException("specialty is required when physician is not specified");
        }
        return medicRepository.chooseRandomMedic(data.getSpeciality(), data.getTime());
    }
}
