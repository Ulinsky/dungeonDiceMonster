package encounter;

import entity.enemy.Enemy;
import entity.player.Player;

public class Encounter {
    Enemy enemy;
    Player player;

    public Encounter(Player player, Enemy enemy) {
        this.enemy = enemy;
        this.player = player;
    }


}
