package be.helb.arami.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FighterRetired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fighterId;
    String name;
    String lastName;
    Boolean isRetired;
}
