package med.vol.api.domain.medic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicRepository extends JpaRepository<Medic, Long>{

    @Query("""
SELECT M FROM Medico M WHERE M.ativo = TRUE 
AND M.speciality = :speciality and M.Id not in( select c.medico.Id from Consulta c where c.data =:time ) order by rand() LIMIT 1""")
    Medic chooseRandomMedic(Speciality speciality, LocalDateTime time);


    @Query("""
        select m.ativo from Medico m where m.Id = :idMedico
""")
    Boolean findAtivoById(Long idMedic);
}
