package med.vol.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")

public class PatientController {

	@Autowired
	private PatientRepository repository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<PatientDataDetails> register(@RequestBody @Valid PatientRegisterData data,
			UriComponentsBuilder  uriBuilder) {
		var patient = new Patient(data);
		repository.save(patient);
		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(patient.getId()).toUri();
		return ResponseEntity.created(uri).body(new PatientDataDetails(patient));
	}
	
	@GetMapping
	public ResponseEntity<Page<DataPatientList>> showPatient(@PageableDefault(size = 10) Pageable page){
		var result =  repository.findAll(page).map(DataPatientList::new);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatientDataDetails> selectPatient(@PathVariable Long id){
		var patient = repository.getReferenceById(id);
		return ResponseEntity.ok(new PatientDataDetails(patient));
	}
	
	
	@PutMapping
	@Transactional
	public ResponseEntity<PatientDataDetails> update(@RequestBody @Valid PatientUpdateData data) {
		var patient = repository.getReferenceById(data.getId());
		patient.updateData(data);
		return ResponseEntity.ok(new PatientDataDetails(patient));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		var patient = repository.getReferenceById(id);
		patient.exclude();
		return ResponseEntity.noContent().build();
	}
	
}
