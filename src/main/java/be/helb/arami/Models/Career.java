package be.helb.arami.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long fighterId;

    int win;
    int loss;


}
