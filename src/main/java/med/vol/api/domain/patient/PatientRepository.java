package med.vol.api.domain.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Query("""
        select p.ativo
        from Paciente p 
        where 
        p.Id = :idPatient
""")
    boolean findAtivoById(Long idPatient);
}
