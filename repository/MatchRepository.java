package a1.repository;

import a1.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByRefereeId(Long refereeId);
    List<Match> findByPlayer1IdOrPlayer2Id(Long p1Id, Long p2Id);
}
