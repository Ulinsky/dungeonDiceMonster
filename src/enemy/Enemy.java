package enemy;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {

    private String name;
    private int hp;
    private int shield;
    private List<Dice> dice;
    private List<Dice> hand;
    private int intitative;

    public Enemy(String name, int hp, int shield, List<Dice> dice, int intitative) {
        this.name = name;
        this.hp = hp;
        this.shield = shield;
        this.dice = dice;
        this.intitative = intitative;
        this.dice = new ArrayList<>();
        this.hand = new ArrayList<>();
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


    public List<Dice> getHand() {
        return hand;
    }

    public int getIntitative() {
        return intitative;
    }

    public String printHand() {
        StringBuilder sb = new StringBuilder("\n");
        hand.forEach((d) -> {
            sb.append(d.toString()).append("\n");
        });
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s with %s hp, %s armor and %s in hand", name, hp, shield, hand.isEmpty() ? "no dice" : printHand());
    }
}
