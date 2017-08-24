package dice.enemy;

import dice.enemy.Enemy;
import dice.player.Inventory;
import dice.dice.Dice;
import java.util.List;

public class Skeleton extends Enemy{

    public Skeleton(String name, int hp, int shield, Inventory inventory, List<Dice> hand, int intitative) {
        super(name, hp, shield, inventory, hand, intitative);
    }

   

}
