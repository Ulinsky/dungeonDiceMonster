package dice.enemy;

import dice.player.Inventory;
import dice.dice.Dice;
import java.util.List;

public abstract class Enemy {

    private String name;
    private int hp;
    private int shield;
    private Inventory inventory;
    private List<Dice> hand;
    private int intitative;

    public Enemy(String name, int hp, int shield, Inventory inventory, List<Dice> hand, int intitative) {
        this.name = name;
        this.hp = hp;
        this.shield = shield;
        this.inventory = inventory;
        this.hand = hand;
        this.intitative = intitative;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getShield() {
        return shield;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Dice> getHand() {
        return hand;
    }

    public int getIntitative() {
        return intitative;
    }
}
