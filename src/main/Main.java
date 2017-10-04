package main;

import dice.Dice;
import entity.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Ulinsky");
        player.drawDice();
        System.out.println(player);
        /*Enemy skeleton = new Skeleton();
        skeleton.drawDice();
        System.out.println(skeleton);*/
        int[] numbers = new Random().ints(0, 6).distinct().limit(3).toArray();
        List<Dice> selectedDice = new ArrayList<>();
        for (int n : numbers) {
            selectedDice.add(player.getDice().get(n));
        }
        System.out.println(player.roll(selectedDice));

    }

}
