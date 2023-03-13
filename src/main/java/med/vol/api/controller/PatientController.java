package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.patient.DataPatientList;
import med.vol.api.patient.Patient;
import med.vol.api.patient.PatientRegisterData;
import med.vol.api.patient.PatientRepository;
import med.vol.api.patient.PatientUpdateData;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

	@Autowired
	private PatientRepository repository;
	
	
	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid PatientRegisterData data) {
		repository.save(new Patient(data));
	}
	
	@GetMapping
	public Page<DataPatientList> showPatient(Pageable page){
		return repository.findAll(page).map(DataPatientList::new);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid PatientUpdateData data) {
		var patient = repository.getReferenceById(data.getId());
		patient.updateData(data);
	}
	
}
