import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BennettIronYard on 10/9/15.
 */
public class Player extends Character {
    String area;
    ArrayList<String> items = new ArrayList();

    public Player() {
        health = 100;
        damage = 20;
    }

    void chooseName() {
        System.out.println("What is your name, traveler?");
        name = Game.nextLine();
        System.out.println(String.format("Good luck, %s", name));
    }

    void chooseWeapon() throws Exception {
        System.out.println("[1] Pick up a sword");
        System.out.println("[2] pick up a mallet");
        int weaponNum = Integer.valueOf(Game.nextLine());
        if (weaponNum == 1) {
            weapon = new Weapon();
            weapon.name = "Sword";
            weapon.damage = 10;
        } else if (weaponNum == 2) {
            weapon = new Weapon();
            weapon.name = "Mallet";
            weapon.damage = 10;
        } else {
            throw new Exception("Invalid weapon.");
        }
        System.out.println(String.format("That's a fine %s1!", weapon.name.toLowerCase()));
    }

    void chooseArea () throws Exception {
        System.out.println("[1] Enter the Forest");
        System.out.println("[2]Enter the Underground tunnel");
        area = Game.nextLine();
        int areaNum = Integer.valueOf(area);
        if (areaNum == 1) {
            System.out.println("Entering the Forest...");
        } else if (areaNum == 2) {
            System.out.println("Entering the tunnel...");
        } else {
            throw new Exception("Invalid area.");
        }
    }

    void findItem(String item) {
        System.out.println("Found item! Pick it up? [y/n]");
        String s = Game.nextLine();
        if (s.equals("y")) {
            System.out.println(String.format("Your found a  %s", item));
            items.add(item);
        }
    }
}


