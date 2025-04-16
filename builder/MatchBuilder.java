package a1.builder;

import a1.model.Match;
import a1.model.Player;
import a1.model.Referee;
import a1.model.Tournament;

import java.time.LocalDate;

public class MatchBuilder {
    private Match match = new Match();

    public static MatchBuilder builder() {
        return new MatchBuilder();
    }

    public MatchBuilder tournament(Tournament tournament) {
        match.setTournament(tournament);
        return this;
    }

    public MatchBuilder player1(Player p1) {
        match.setPlayer1(p1);
        return this;
    }

    public MatchBuilder player2(Player p2) {
        match.setPlayer2(p2);
        return this;
    }

    public MatchBuilder referee(Referee referee) {
        match.setReferee(referee);
        return this;
    }

    public MatchBuilder matchDate(LocalDate date) {
        match.setMatchDate(date);
        return this;
    }

    public MatchBuilder court(String court) {
        match.setCourt(court);
        return this;
    }

    public MatchBuilder score(int s1, int s2) {
        match.setScorePlayer1(s1);
        match.setScorePlayer2(s2);
        return this;
    }

    public Match build() {
        return match;
    }
}
