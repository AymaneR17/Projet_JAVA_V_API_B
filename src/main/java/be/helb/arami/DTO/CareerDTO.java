package be.helb.arami.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class CareerDTO {
   private Long id;
   private Long fighterId;
   private int win;
   private int loss;
}
