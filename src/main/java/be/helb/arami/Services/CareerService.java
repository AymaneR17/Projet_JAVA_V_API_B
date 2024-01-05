package be.helb.arami.Services;

import be.helb.arami.Client.FighterApiClient;
import be.helb.arami.DAO.CareerRepository;
import be.helb.arami.DTO.CareerDTO;
import be.helb.arami.DTO.FighterDTO;
import be.helb.arami.Models.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CareerService {

    private final CareerRepository careerRepository;
    private final FighterApiClient fighterApiClient;

    @Autowired
    public CareerService(CareerRepository careerRepository, FighterApiClient fighterApiClient) {
        this.careerRepository = careerRepository;
        this.fighterApiClient = fighterApiClient;
    }

    public Career createCareer(Long fighterId, Career career) {
        FighterDTO fighterDTO = fighterApiClient.getFighterById(fighterId);

        if (fighterDTO != null) {

            career = new Career();
            career.setFighterId(fighterDTO.getId());
            return careerRepository.save(career);
        } else {
            return null;
        }
    }


}
