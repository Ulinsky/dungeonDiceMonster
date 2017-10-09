package encounter;

import entity.enemy.Enemy;
import entity.player.Player;
import result.Result;

public class Encounter {
    Enemy enemy;
    Player player;

    public Encounter(Player player, Enemy enemy) {
        this.enemy = enemy;
        this.player = player;
    }

    public void playerTakesTurn(Result result) {
        if (result.isPiercing()) {
            enemy.setHp(enemy.getHp() - result.getDamage());
        } else {
            int overflow = result.getDamage() - enemy.getShield();
            if (overflow > 0) {
                enemy.setShield(0);
                enemy.setHp(enemy.getHp() - overflow);
            } else {
                enemy.setShield(enemy.getShield() - result.getDamage());
            }
        }

    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void enemyTakesTurn(Result result) {
        if (result.isPiercing()) {
            player.setHp(player.getHp() - result.getDamage());
        } else {
            int overflow = result.getDamage() - player.getShield();
            if (overflow > 0) {
                player.setShield(0);
                player.setHp(player.getHp() - overflow);
            } else {
                player.setShield(player.getShield() - result.getDamage());
            }
        }
    }

    public boolean enemyHasLife() {

        //System.out.println(String.format("%s has been annihilated!", enemy.getName()));
        return enemy.getHp() > 0;
    }

    public boolean playerHasLife() {
        //System.out.println(String.format("%s has failed in their quest...", player.getName()));

        return player.getHp() > 0;

    }

    public void performCombat() {

        //pause(1100);
        if (player.getInitiative() - enemy.getIntitative() > 0) {
            playerGoesFirst();
        } else {
            enemyGoesFirst();
        }
    }

    public void playerGoesFirst() {
        System.out.println(player.printHand());

        Result r = player.roll(player.getPlayerInput());
        playerTakesTurn(r);

        System.out.println(r);
        if (!enemyHasLife()) {
            System.out.println("The " + enemy.getName() + " has been destroyed");
            return;
        }

        System.out.println(player);
        System.out.println(enemy);
        System.out.println("The " + enemy.getName() + " makes it´s turn.");
        r = enemy.roll();
        enemyTakesTurn(r);
        System.out.println(r);
        System.out.println(player);
        System.out.println(enemy);
        if (!playerHasLife()) {
            System.out.println("You have failed in your quest");
        }
    }

    public void enemyGoesFirst() {
        System.out.println("The " + enemy.getName() + " makes it´s turn.");
        Result r = enemy.roll();
        enemyTakesTurn(r);

        System.out.println(r);

        System.out.println(enemy);
        System.out.println(player);

        if (!playerHasLife()) {
            System.out.println("You have failed in your quest");
            return;
        }

        System.out.println(player.printHand());

        r = player.roll(player.getPlayerInput());
        playerTakesTurn(r);
        System.out.println(r);
        System.out.println(player);
        System.out.println(enemy);
        if (!enemyHasLife()) {
            System.out.println("The " + enemy.getName() + " has been destroyed");
        }
    }

}
