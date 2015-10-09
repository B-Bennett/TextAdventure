import java.util.Scanner;

/**
 * Created by BennettIronYard on 10/8/15.
 */
public class Game {
    public static void run() throws Exception {
        System.out.println("Welcome to my text adventure.");
        System.out.println("What is your name, traveler?");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Good luck," + name);

        System.out.println("[1] Pick up a sword");
        System.out.println("[2] pick up a mallet");
        String weapon = scanner.nextLine();
        int weaponNum = Integer.valueOf(weapon);
        if (weaponNum == 1) {
            System.out.println("That's a fine sword!");
        }else if (weaponNum == 2) {
            System.out.println("That's a heavy mallet");
        }else {
            throw new Exception("Invald weapon.");
        }

        System.out.println("[1] Enter the Forest");
        System.out.println("[2] Enter the Underground tunnel");
        String area = scanner.nextLine();
        int areaNum = Integer.valueOf(area);
        if (areaNum == 1) {
            System.out.println("Entering the Forest...");
        }else if (areaNum == 2){
            System.out.println("Entering the tunnel...");
        }else {
            throw new   Exception("Invalid area.");
        }
    }
}
