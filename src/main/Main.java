package main;

import encounter.Encounter;
import entity.enemy.Enemy;
import entity.enemy.Skeleton;
import entity.player.Player;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Ulinsky");
        player.drawDice();
        Enemy skeleton = new Skeleton();
        skeleton.drawDice();
        Encounter e = new Encounter(player, skeleton);
        System.out.println(player);
        System.out.println(String.format("A %s blocks your way!", e.getEnemy().getName()));
        pause(800);
        System.out.println(skeleton);
        while (e.playerHasLife() && e.enemyHasLife()) {
            e.performCombat();
        }
        System.out.println("Combat has ended");
    }

    public static void pause(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
