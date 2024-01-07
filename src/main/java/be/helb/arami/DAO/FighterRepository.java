package be.helb.arami.DAO;

import be.helb.arami.Models.FighterRetired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FighterRepository extends JpaRepository<FighterRetired, Long> {
    List<FighterRetired> findByFighterIdAndIsRetired(Long fighterId, Boolean isRetired);
}
