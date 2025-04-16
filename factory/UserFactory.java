package a1.factory;

import a1.model.Administrator;
import a1.model.Player;
import a1.model.Referee;
import a1.model.User;

public class UserFactory {
    public static User createUser(String role) {
        return switch (role.toUpperCase()) {
            case "ADMIN", "ADMINISTRATOR" -> new Administrator();
            case "REFEREE" -> new Referee();
            case "PLAYER" -> new Player();
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };
    }
}
