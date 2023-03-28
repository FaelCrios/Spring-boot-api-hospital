package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TimeInAdvanceValidation implements ValidationScheludeQuery{
    public void Validation(DataTreatmentPlanner data){
        var timeSchedule = data.getTime();
        var now = LocalDateTime.now();
        var difference = Duration.between(now, timeSchedule).toMinutes();

        if(difference < 30){
            throw new ValidationException("Query must be scheduled with 30 minutes in advance");
        }


    }
}
