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

    public void playerDealsDamage(Result result) {
        if (result.isPiercing()) {
            enemy.setHp(enemy.getHp() - result.getDamage());
            if (enemy.getHp() <= 0) {
                playerWins();
                return;
            }
        } else {
            int overflow = result.getDamage() - enemy.getShield();
            if (overflow > 0) {
                enemy.setShield(0);
                enemy.setHp(enemy.getHp() - overflow);
            } else {
                enemy.setShield(enemy.getShield() - result.getDamage());
            }
        }
        if (enemy.getHp() <= 0) {
            playerWins();
            return;
        }
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void enemyDealsDamage(Result result) {
        if (result.isPiercing()) {
            player.setHp(player.getHp() - result.getDamage());
            if (player.getHp() <= 0) {
                playerLoses();
                return;
            }
        } else {
            int overflow = result.getDamage() - player.getShield();
            if (overflow > 0) {
                player.setShield(0);
                player.setHp(player.getHp() - overflow);
            } else {
                player.setShield(player.getShield() - result.getDamage());
            }
        }
        if (player.getHp() <= 0) {
            playerLoses();
            return;
        }
    }

    public void playerWins() {
        System.out.println(String.format("%s has been annihilated!", enemy.getName()));
    }

    public void playerLoses() {
        System.out.println(String.format("%s has failed in their quest...", player.getName()));
    }

}
