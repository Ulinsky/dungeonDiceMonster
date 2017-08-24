package dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    private String name;
    private int hp;
    private int shield;
    //  private final Inventory inventory;
    private List<Dice> hand;
    private final int initiative;
    private final List<Dice> dice;

    public List<Dice> getDice() {
//    return Collections.unmodifiableList(dice);
        return dice;
    }

    public void addDice(Dice dice) {
        this.dice.add(dice);
    }

    public void removeDice(Dice dice) {
        this.dice.remove(dice);
    }

    public void shuffleDice() {
        Collections.shuffle(dice);
    }

    public int getInitiative() {
        return initiative;
    }

    public Player() {
        this.hp = 20;
        this.shield = 0;
        // this.inventory = new Inventory();
        this.initiative = 10;
        this.dice = new ArrayList<>();
        this.hand = new ArrayList<>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp > 20) {
            hp = 20;
        }
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
        if (this.shield > 10) {
            shield = 10;
        }
    }

    public List<Dice> getInventory() {
        return dice;
    }

    public void drawDice() {
        Random rnd = new Random();
        shuffleDice();
        if (hand != null) {
            hand.forEach((Dice d) -> {
                addDice(d);
                hand.remove(d);
            });
        }
        for (int i = 0; i < 5; i++) {
//            System.out.println("ENTERED FOR LOOP");
            int draw = rnd.nextInt(dice.size());
//            System.out.println("DRAW NUMBER IS: "+draw);

            Dice singleDice = dice.get(draw);
            //     System.out.println("DICE IS " + singleDice);
//            System.out.println("ADDING DICE");
            hand.add(singleDice);
//            System.out.println("FINISHED ADD");
            removeDice(singleDice);
        }
    }

    public String getName() {
        return name;
    }

    public String printInventory() {
        StringBuilder sb = new StringBuilder();
        dice.forEach((d) -> {
            sb.append(d.toString()).append("\n");
        });
        return sb.toString();
    }
    
    public String printHand() {
        StringBuilder sb = new StringBuilder("\n");
        hand.forEach((d) -> {
            sb.append(d.toString()).append("\n");
        });
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result roll(List<Dice> dice) {
        List<Side> results = new ArrayList<>();
        dice.forEach((Dice d) -> {
            results.add(d.roll());
        });
        return new Result(results);
    }

    @Override
    public String toString() {
        return String.format("%s with %s hp, %s armor and %s in hand", name, hp, shield, hand.isEmpty() ? "no dice" : printHand());
    }

}
