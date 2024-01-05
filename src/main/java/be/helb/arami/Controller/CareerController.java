package be.helb.arami.Controller;


import be.helb.arami.DTO.CareerDTO;
import be.helb.arami.Models.Career;
import be.helb.arami.Services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CareerController {
    public CareerService careerService;

    @Autowired
    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }


    @PostMapping("career/create/{fighterId}")
    public ResponseEntity<Career> createCareer(@PathVariable Long fighterId, @RequestBody Career career ) {
        Career createdCareer = careerService.createCareer(fighterId, career);

        if (createdCareer != null) {
            return ResponseEntity.ok(createdCareer);
        } else {
            // Gérer le cas où le combattant n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }
}
