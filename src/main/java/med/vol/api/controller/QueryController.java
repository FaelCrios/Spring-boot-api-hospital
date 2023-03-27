package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.domain.query.ConsultationSchedule;
import med.vol.api.domain.query.DataTreatmentDetails;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class QueryController {

    @Autowired
    private ConsultationSchedule schedule;

    public ResponseEntity planner(@RequestBody @Valid DataTreatmentPlanner data){

        schedule.schedule(data);
        return ResponseEntity.ok(new DataTreatmentDetails());
    }

}
