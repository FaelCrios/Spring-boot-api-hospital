package med.vol.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")

public class MedicController {

	@Autowired
	private MedicRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<MedicDataDetails> register(@RequestBody @Valid MedicRegisterData data,
			UriComponentsBuilder uriBuilder) {

		var medic = new Medic(data);

		repository.save(medic);

		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medic.getId()).toUri();

		return ResponseEntity.created(uri).body(new MedicDataDetails(medic));
	}

	@GetMapping
	public ResponseEntity<Page<DataMedicList>> showMedic(@PageableDefault(size = 10) Pageable page) {
		var result = repository.findAll(page).map(DataMedicList::new);
		return ResponseEntity.ok(result);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<MedicDataDetails> update(@RequestBody @Valid MedicUpdateData data) {
		var medic = repository.getReferenceById(data.getId());
		medic.updateData(data);
		return ResponseEntity.ok(new MedicDataDetails(medic));

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		var medic = repository.getReferenceById(id);
		medic.exclude();

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicDataDetails> selectMedic(@PathVariable Long id) {
		var medic = repository.getReferenceById(id);
		return ResponseEntity.ok(new MedicDataDetails(medic));
	}

}
