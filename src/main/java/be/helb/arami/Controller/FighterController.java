    package be.helb.arami.Controller;


    import be.helb.arami.DTO.FighterRetiredDTO;
    import be.helb.arami.Models.FighterRetired;
    import be.helb.arami.Services.FighterService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    public class FighterController {

        FighterService fighterService;

        public FighterController(FighterService fighterService){
            this.fighterService = fighterService;
        }

        @GetMapping(value ="/fighter/retirement")
        public ResponseEntity<List<FighterRetiredDTO>> getFighterRetiredById(Long id, Boolean isRetired){
           List<FighterRetiredDTO> retiredFighters = fighterService.getFighterRetiredById(id, isRetired);
                return ResponseEntity.ok(retiredFighters);
        }

        @PostMapping("create/fighter/retirement")
        public ResponseEntity<FighterRetiredDTO> createFighterRetired(@RequestBody FighterRetiredDTO fighterRetiredDTO){
            FighterRetired fighterRetired = new FighterRetired();
            fighterRetired.setName(fighterRetiredDTO.getName());
            fighterRetired.setLastName(fighterRetiredDTO.getLastName());
            fighterRetired.setIsRetired(fighterRetiredDTO.getIsRetired());

            FighterRetiredDTO savedFighter = fighterService.createFighterRetired(fighterRetired);

            return ResponseEntity.ok(savedFighter);
        }
    }
