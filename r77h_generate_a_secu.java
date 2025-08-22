import java.util.Random;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class R77H_Generate_A_Secu {
    private static final int GAME_ID_LENGTH = 16;
    private static final int PLAYER_ID_LENGTH = 8;
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private SecureRandom secureRandom;

    public R77H_Generate_A_Secu() {
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public String generateGameID() {
        return generateRandomString(GAME_ID_LENGTH);
    }

    public String generatePlayerID() {
        return generateRandomString(PLAYER_ID_LENGTH);
    }

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(secureRandom.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        R77H_Generate_A_Secu integrator = new R77H_Generate_A_Secu();
        System.out.println("Game ID: " + integrator.generateGameID());
        System.out.println("Player ID: " + integrator.generatePlayerID());
    }
}