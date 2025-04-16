package a1.config;

import a1.factory.UserFactory;
import a1.builder.MatchBuilder;
import a1.model.*;
import a1.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepo,
                                      TournamentRepository tournamentRepo,
                                      MatchRepository matchRepo) {


        return args -> {
            matchRepo.deleteAll();
            tournamentRepo.deleteAll();
            userRepo.deleteAll();

            User player1 = UserFactory.createUser("PLAYER");
            player1.setUsername("player1"); player1.setEmail("player1@mail.com"); player1.setPassword("pass");

            User player2 = UserFactory.createUser("PLAYER");
            player2.setUsername("player2"); player2.setEmail("player2@mail.com"); player2.setPassword("pass");

            User player3 = UserFactory.createUser("PLAYER");
            player3.setUsername("player3"); player3.setEmail("player3@mail.com"); player3.setPassword("pass");

            User player4 = UserFactory.createUser("PLAYER");
            player4.setUsername("player4"); player4.setEmail("player4@mail.com"); player4.setPassword("pass");

            User player5 = UserFactory.createUser("PLAYER");
            player5.setUsername("player5"); player5.setEmail("player5@mail.com"); player5.setPassword("pass");


            Referee ref1 = (Referee) UserFactory.createUser("REFEREE");
            ref1.setUsername("ref1"); ref1.setEmail("ref1@mail.com"); ref1.setPassword("pass");

            Referee ref2 = (Referee) UserFactory.createUser("REFEREE");
            ref2.setUsername("ref2"); ref2.setEmail("ref2@mail.com"); ref2.setPassword("pass");

            Referee ref3 = (Referee) UserFactory.createUser("REFEREE");
            ref3.setUsername("ref3"); ref3.setEmail("ref3@mail.com"); ref3.setPassword("pass");

            Referee ref4 = (Referee) UserFactory.createUser("REFEREE");
            ref4.setUsername("ref4"); ref4.setEmail("ref4@mail.com"); ref4.setPassword("pass");

            Referee ref5 = (Referee) UserFactory.createUser("REFEREE");
            ref5.setUsername("ref5"); ref5.setEmail("ref5@mail.com"); ref5.setPassword("pass");


            userRepo.saveAll(List.of(player1, player2,player3,player4,player5, ref1,ref2,ref3,ref4,ref5));

            Tournament t1 = new Tournament("Spring Open", LocalDate.of(2025, 5, 1), "Paris");
            Tournament t2 = new Tournament("Summer Slam", LocalDate.of(2025, 6, 10), "Madrid");
            Tournament t3 = new Tournament("Autumn Classic", LocalDate.of(2025, 9, 15), "Berlin");
            Tournament t4 = new Tournament("Winter Cup", LocalDate.of(2025, 12, 1), "Oslo");
            Tournament t5 = new Tournament("Championship Finals", LocalDate.of(2025, 11, 20), "London");


            List<Tournament> tournaments = List.of(t1, t2, t3, t4, t5);
            tournamentRepo.saveAll(tournaments);

            Match m1 = MatchBuilder.builder()
                    .player1((Player) player2)
                    .player2((Player) player5)
                    .referee(ref4)
                    .tournament(t1)
                    .court("Court A")
                    .matchDate(LocalDate.of(2025, 5, 1))
                    .score(0, 0)
                    .build();

            Match m2 = MatchBuilder.builder()
                    .player1((Player) player5)
                    .player2((Player) player3)
                    .referee(ref2)
                    .tournament(t1)
                    .court("Court B")
                    .matchDate(LocalDate.of(2025, 5, 2))
                    .score(0, 0)
                    .build();

            Match m3 = MatchBuilder.builder()
                    .player1((Player) player3)
                    .player2((Player) player4)
                    .referee(ref3)
                    .tournament(t1)
                    .court("Court C")
                    .matchDate(LocalDate.of(2025, 5, 3))
                    .score(0, 0)
                    .build();

            Match m4 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player2)
                    .referee(ref5)
                    .tournament(t1)
                    .court("Court D")
                    .matchDate(LocalDate.of(2025, 5, 4))
                    .score(0, 0)
                    .build();

            Match m5 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player4)
                    .referee(ref1)
                    .tournament(t1)
                    .court("Court E")
                    .matchDate(LocalDate.of(2025, 5, 5))
                    .score(0, 0)
                    .build();

            Match m6 = MatchBuilder.builder()
                    .player1((Player) player2)
                    .player2((Player) player5)
                    .referee(ref4)
                    .tournament(t2)
                    .court("Court X")
                    .matchDate(LocalDate.of(2026, 5, 1))
                    .score(0, 0)
                    .build();

            Match m7 = MatchBuilder.builder()
                    .player1((Player) player5)
                    .player2((Player) player3)
                    .referee(ref2)
                    .tournament(t2)
                    .court("Court Z")
                    .matchDate(LocalDate.of(2026, 5, 2))
                    .score(0, 0)
                    .build();

            Match m8 = MatchBuilder.builder()
                    .player1((Player) player3)
                    .player2((Player) player4)
                    .referee(ref3)
                    .tournament(t2)
                    .court("Court S")
                    .matchDate(LocalDate.of(2026, 5, 3))
                    .score(0, 0)
                    .build();

            Match m9 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player4)
                    .referee(ref1)
                    .tournament(t2)
                    .court("Court G")
                    .matchDate(LocalDate.of(2026, 5, 5))
                    .score(0, 0)
                    .build();

            Match m10 = MatchBuilder.builder()
                    .player1((Player) player2)
                    .player2((Player) player5)
                    .referee(ref4)
                    .tournament(t2)
                    .court("Court L")
                    .matchDate(LocalDate.of(2026, 5, 1))
                    .score(0, 0)
                    .build();

            Match m11 = MatchBuilder.builder()
                    .player1((Player) player5)
                    .player2((Player) player3)
                    .referee(ref2)
                    .tournament(t3)
                    .court("Court K")
                    .matchDate(LocalDate.of(2025, 5, 21))
                    .score(0, 0)
                    .build();

            Match m12 = MatchBuilder.builder()
                    .player1((Player) player3)
                    .player2((Player) player4)
                    .referee(ref3)
                    .tournament(t3)
                    .court("Court F")
                    .matchDate(LocalDate.of(2025, 5, 23))
                    .score(0, 0)
                    .build();

            Match m13 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player2)
                    .referee(ref5)
                    .tournament(t3)
                    .court("Court O")
                    .matchDate(LocalDate.of(2025, 5, 14))
                    .score(0, 0)
                    .build();

            Match m14 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player4)
                    .referee(ref1)
                    .tournament(t3)
                    .court("Court P")
                    .matchDate(LocalDate.of(2025, 5, 25))
                    .score(0, 0)
                    .build();

            Match m15 = MatchBuilder.builder()
                    .player1((Player) player2)
                    .player2((Player) player5)
                    .referee(ref4)
                    .tournament(t3)
                    .court("Court I")
                    .matchDate(LocalDate.of(2025, 5, 11))
                    .score(0, 0)
                    .build();

            Match m16 = MatchBuilder.builder()
                    .player1((Player) player5)
                    .player2((Player) player3)
                    .referee(ref2)
                    .tournament(t4)
                    .court("Court J")
                    .matchDate(LocalDate.of(2025, 11, 2))
                    .score(0, 0)
                    .build();

            Match m17 = MatchBuilder.builder()
                    .player1((Player) player3)
                    .player2((Player) player4)
                    .referee(ref3)
                    .tournament(t4)
                    .court("Court C")
                    .matchDate(LocalDate.of(2025, 12, 3))
                    .score(0, 0)
                    .build();

            Match m18 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player2)
                    .referee(ref5)
                    .tournament(t4)
                    .court("Court Q")
                    .matchDate(LocalDate.of(2025, 10, 4))
                    .score(0, 0)
                    .build();

            Match m19 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player4)
                    .referee(ref1)
                    .tournament(t4)
                    .court("Court W")
                    .matchDate(LocalDate.of(2025, 10, 5))
                    .score(0, 0)
                    .build();

            Match m20 = MatchBuilder.builder()
                    .player1((Player) player2)
                    .player2((Player) player5)
                    .referee(ref4)
                    .tournament(t4)
                    .court("Court R")
                    .matchDate(LocalDate.of(2025, 11, 1))
                    .score(0, 0)
                    .build();

            Match m21 = MatchBuilder.builder()
                    .player1((Player) player5)
                    .player2((Player) player3)
                    .referee(ref2)
                    .tournament(t5)
                    .court("Court T")
                    .matchDate(LocalDate.of(2027, 5, 2))
                    .score(0, 0)
                    .build();

            Match m22 = MatchBuilder.builder()
                    .player1((Player) player3)
                    .player2((Player) player4)
                    .referee(ref3)
                    .tournament(t5)
                    .court("Court U")
                    .matchDate(LocalDate.of(2027, 5, 3))
                    .score(0, 0)
                    .build();

            Match m23 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player2)
                    .referee(ref5)
                    .tournament(t5)
                    .court("Court V")
                    .matchDate(LocalDate.of(2027, 5, 4))
                    .score(0, 0)
                    .build();

            Match m24 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player4)
                    .referee(ref1)
                    .tournament(t5)
                    .court("Court M")
                    .matchDate(LocalDate.of(2027, 5, 5))
                    .score(0, 0)
                    .build();

            Match m25 = MatchBuilder.builder()
                    .player1((Player) player1)
                    .player2((Player) player2)
                    .referee(ref5)
                    .tournament(t5)
                    .court("Court G")
                    .matchDate(LocalDate.of(2027, 5, 4))
                    .score(0, 0)
                    .build();

            matchRepo.saveAll(List.of(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,
                    m16,m17,m18,m19,m20,m21,m22,m23,m24,m25));
        };
    }
}

