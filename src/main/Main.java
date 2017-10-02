package main;

import dice.*;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Trole");
        for (int i = 0; i < 30; i++) {
            List<Side> playerSides = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                playerSides.add(generateNewSide());
            }
            player.addDice(new Dice(playerSides));
        }
        System.out.println(player);
        player.drawDice();
        System.out.println(player);

//       List<Side> sides = new ArrayList<>();
//       sides.add(new Attack(2));
//       sides.add(new Attack(2));
//       sides.add(new Attack(2));
//       sides.add(new Attack(3));
//       sides.add(new Attack(3));
//       sides.add(new Crit());
//       Dice midTierAttack = new Dice(sides);
//       
//        System.out.println(midTierAttack);
        Enemy skeleton = new Skeleton();
        List<Side> sides = new ArrayList<>();
        sides.add(player.getHand().get(2).getSides().get(1));
        System.out.println(player.getHand().get(2).getSides().get(1));
        System.out.println((player.getHand().get(3).getSides().get(4)));
        sides.add(player.getHand().get(3).getSides().get(4));
        System.out.println((player.getHand().get(1).getSides().get(5)));
        sides.add(player.getHand().get(1).getSides().get(5));
        System.out.println(player.roll(sides));

   }

    public static Side generateNewSide() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0:
                return new Attack(rnd.nextInt(7) + 1);
            case 1:
                return new Crit();
            case 2:
                return new Healing(rnd.nextInt(7) + 1);
            case 3:
                return new Piercing();
            case 4:
                return new Shielding(rnd.nextInt(4) + 1);
            default:
                return null;
        }
    }
}
