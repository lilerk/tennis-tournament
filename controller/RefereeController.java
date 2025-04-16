package a1.controller;

import a1.model.Match;
import a1.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/referee")
public class RefereeController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/{refereeId}/matches")
    public List<Match> getRefereeMatches(@PathVariable Long refereeId) {
        return matchRepository.findByRefereeId(refereeId);
    }
}

