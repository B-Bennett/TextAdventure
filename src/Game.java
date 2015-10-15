import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by BennettIronYard on 10/8/15.
 */
public class Game {
    static Player player;
    static final String FILE_NAME = "save,json";

    public static void main(String [] args) throws Exception {
        System.out.println("Welcome to my text adventure.");
        player = loadGame();

        if (player == null) {
            player = new Player();
            player.chooseName();
            player.chooseWeapon();
            player.chooseArea();
            player.findItem("Shield");
        }

        Weapon ogreWeapon = new Weapon();
        ogreWeapon.name = "Club";
        ogreWeapon.damage = 5;
        Enemy ogre = new Enemy("Ogre", 50, 5, ogreWeapon);
        player.battle(ogre);

        saveGame();
    }

    static String nextLine() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.startsWith("/")) {
            if (s.equals("help")) {
                System.out.println("These are the available commands:");
                System.out.println("help => List available commands.");
            } else if (s.equals("/exit")) {
                System.exit(0);
            } else if (s.equals("/inv")) {
                if (player.items.size() == 0) {
                    System.out.println("You have no items");
                }
                for (Object item : player.items) {
                    System.out.println(item);
                }
            }
            return nextLine();
        } else {
            return s;
        }
    }

    static void saveGame() {
        File f = new File(FILE_NAME);
        JsonSerializer serializer = new JsonSerializer();
        String contentsToSave = serializer.serialize(player);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentsToSave);
            fw.close();
        } catch (Exception e) {

        }
    }

    static Player loadGame() {
     try {
         File f = new File(FILE_NAME);
         FileReader fr = new FileReader(f);
         int fileSize = (int) f.length();
         char[] contents = new char[fileSize];
         fr.read(contents);
         String fileContents = new String(contents);
         JsonParser parser = new JsonParser();
         return parser.parse(fileContents, Player.class);
     }catch (Exception e) {
         return null;
     }
    }
}
