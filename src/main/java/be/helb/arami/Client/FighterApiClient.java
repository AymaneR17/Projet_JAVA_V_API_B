package be.helb.arami.Client;

import be.helb.arami.DTO.CareerDTO;
import be.helb.arami.DTO.FighterDTO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface FighterApiClient {
    @RequestLine("GET /fighter/{fighterId}")
    FighterDTO getFighterById(@PathVariable("fighterId") Long fighterId);
}
