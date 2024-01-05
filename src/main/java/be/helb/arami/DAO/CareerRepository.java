package be.helb.arami.DAO;

import be.helb.arami.DTO.CareerDTO;
import be.helb.arami.Models.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {


}
