package med.vol.api.domain.query;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultationRepository  extends JpaRepository<Treatment, Long> {
    boolean existsByMedicoIdAndData(Long idMedic, LocalDateTime time);

    boolean existsByPacienteIdAndDataBetween(Long idPatient, LocalDateTime firstTime, LocalDateTime lastTime);
}
