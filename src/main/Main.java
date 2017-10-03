package main;

import entity.enemy.Enemy;
import entity.enemy.Skeleton;
import entity.player.Player;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Ulinsky");
        /*for (int i = 0; i < 30; i++) {
            List<Side> playerSides = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                playerSides.add(generateNewSide());
            }
            player.addDice(new Dice(playerSides));
        }*/
        // System.out.println(player);
        player.drawDice();
        System.out.println(player);
        Enemy skeleton = new Skeleton();
        skeleton.drawDice();
        System.out.println(skeleton);

    }

    /*public static Side generateNewSide() {
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
    }*/
}
