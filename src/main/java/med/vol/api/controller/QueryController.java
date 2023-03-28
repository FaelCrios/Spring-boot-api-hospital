package med.vol.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.query.ConsultationSchedule;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")

public class QueryController {

    @Autowired
    private ConsultationSchedule schedule;

    @PostMapping
    @Transactional
    public ResponseEntity planner(@RequestBody @Valid DataTreatmentPlanner data){
        var dto = schedule.schedule(data);

        return ResponseEntity.ok(dto);
    }

}
