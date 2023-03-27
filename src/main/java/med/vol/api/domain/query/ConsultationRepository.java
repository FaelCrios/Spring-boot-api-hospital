package med.vol.api.domain.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository  extends JpaRepository<Treatment, Long> {
}
