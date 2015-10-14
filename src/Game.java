import java.util.Objects;
import java.util.Scanner;

/**
 * Created by BennettIronYard on 10/8/15.
 */
public class Game {
    static Player player;

    public static void main(String [] args) throws Exception {
        System.out.println("Welcome to my text adventure.");
        player = new Player();

    while (true) {
        player.chooseName();
        player.chooseWeapon();
        player.chooseArea();
        player.findItem("Shield");

        Weapon ogreWeapon = new Weapon();
        ogreWeapon.name = "Club";
        ogreWeapon.damage = 5;
        Enemy ogre = new Enemy("Ogre", 50, 5, ogreWeapon);
        player.battle(ogre);
        }
    }

    static String nextLine() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.startsWith("/")) {
            if (s.equals ("help")) {
                System.out.println("These are the available commands:");
                System.out.println("help => List available commands.");
            }else if (s.equals("/exit")) {
                System.exit(0);
            }else if (s.equals("/inv")) {
                if (player.items.size() == 0) {
                    System.out.println("You have no items");
                }
                for (Object item : player.items) {
                    System.out.println(item);
                }
            }
            return nextLine();
        }else {
            return s;
        }
    }
}
