package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.medic.DataMedicList;
import med.vol.api.medic.Medic;
import med.vol.api.medic.MedicRegisterData;
import med.vol.api.medic.MedicRepository;
import med.vol.api.medic.MedicUpdateData;

@RestController
@RequestMapping("/medicos")
public class MedicController {
	
	@Autowired
	private MedicRepository repository;

	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid MedicRegisterData data) {
		repository.save(new Medic(data));
	}
	
	
	@GetMapping
	public Page<DataMedicList> showMedic(@PageableDefault(size=10) Pageable page){
		return repository.findAll(page).map(DataMedicList::new);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid MedicUpdateData data) {
		var medic = repository.getReferenceById(data.getId());
		medic.updateData(data);
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		var medic = repository.getReferenceById(id);
		medic.exclude();
	}
	
}
