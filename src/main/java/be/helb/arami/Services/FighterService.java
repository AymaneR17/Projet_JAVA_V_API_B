package be.helb.arami.Services;


import be.helb.arami.DAO.FighterRepository;
import be.helb.arami.DTO.FighterRetiredDTO;
import be.helb.arami.Models.FighterRetired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FighterService {


    FighterRepository fighterRepository;

    @Autowired
    public FighterService(FighterRepository fighterRepository){
        this.fighterRepository = fighterRepository;
    }

    public List<FighterRetiredDTO> getFighterRetiredById(Long id, Boolean isRetired){
      List<FighterRetired> fighterRetireds = fighterRepository.findByFighterIdAndIsRetired(id, isRetired);
      return ConvertToDtoList(fighterRetireds);
    }
//
    public FighterRetiredDTO createFighterRetired(FighterRetired fighterRetired){
            FighterRetired savedFighter = fighterRepository.save(fighterRetired);
            return ConvertToDTO(savedFighter);

    }
    private FighterRetiredDTO ConvertToDTO(FighterRetired fighterRetired) {
        if (fighterRetired == null) return null;

        FighterRetiredDTO fighterRetiredDTO = new FighterRetiredDTO();
        fighterRetiredDTO.setId(fighterRetired.getFighterId());
        fighterRetiredDTO.setName(fighterRetired.getName());
        fighterRetiredDTO.setLastName(fighterRetired.getLastName());
        fighterRetiredDTO.setIsRetired(fighterRetired.getIsRetired());
        return fighterRetiredDTO;
    }

    private List<FighterRetiredDTO> ConvertToDtoList(List<FighterRetired> fighterRetireds){
        return fighterRetireds.stream().map(this::ConvertToDTO).collect(Collectors.toList());
    }

}
