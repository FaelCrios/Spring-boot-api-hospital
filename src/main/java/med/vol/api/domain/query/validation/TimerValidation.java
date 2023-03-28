package med.vol.api.domain.query.validation;

import jakarta.validation.ValidationException;
import med.vol.api.domain.query.DataTreatmentPlanner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class TimerValidation implements ValidationScheludeQuery{

    public void Validation(DataTreatmentPlanner data){
        var dataSchedule = data.getTime();
        var sunday = dataSchedule.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeHospitalOpen = dataSchedule.getHour() < 7;
        var afterHospitalClose = dataSchedule.getHour() > 18;
        if(sunday || beforeHospitalOpen || afterHospitalClose){
            throw new ValidationException("Schedule out of hospital working time");
        }

    }
}
