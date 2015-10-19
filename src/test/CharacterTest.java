import static org.junit.Assert.*;

/**
 * Created by BennettIronYard on 10/19/15.
 */
public class CharacterTest {

    @org.junit.Test
    public void testBattle() throws Exception {


        public void testBattle() throws Exception {
            Weapon plyaerWeapon = new Weapon();
            plyaerWeapon.damage = 50;
            Player player = new Player();
            player.weapon = plyaerWeapon;

            Weapon enemyWeapon = new Weapon();
            enemyWeapon.damage = 10;
            Enemy enemy = new Enemy("Test Enemy", 50, 10, enemyWeapon);

            player.battle(enemy);

            assertTrue(player.health > 0);
            assertTrue(enemy.health <= 0);

        }
    }
}