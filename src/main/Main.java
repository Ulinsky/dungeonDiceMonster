package main;

import dice.Dice;
import encounter.Encounter;
import entity.enemy.Enemy;
import entity.enemy.Skeleton;
import entity.player.Player;
import result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Ulinsky");
        player.drawDice();
        System.out.println(player);
        Enemy skeleton = new Skeleton();
        skeleton.drawDice();
        System.out.println(skeleton);
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " RUN\n=====================\n\n");
            int[] numbers = new Random().ints(0, 6).distinct().limit(3).toArray();
            List<Dice> selectedDice = new ArrayList<>();
            for (int n : numbers) {
                selectedDice.add(player.getDice().get(n));
            }
            Encounter e = new Encounter(player, skeleton);
            Result test = player.roll(selectedDice);
            System.out.println(test);
            e.playerDealsDamage(test);
            System.out.println(e.getEnemy());
        }
    }

}
