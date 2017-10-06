package entity.player;

import dice.*;
import result.Result;

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
    Random rnd;

    public List<Dice> getDice() {
//    return Collections.unmodifiableList(dice);
        return dice;
    }

    public void generateDice() {
        dice.clear();
        for (int i = 0; i < 30; i++) {
            List<Side> playerSides = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                playerSides.add(generateNewSide());
            }
            dice.add(new Dice(playerSides));
        }
    }

    private Side generateNewSide() {

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
        rnd = new Random();
        this.hp = 20;
        this.shield = 0;
        // this.inventory = new Inventory();
        this.initiative = 10;
        this.dice = new ArrayList<>();
        this.hand = new ArrayList<>();
        generateDice();
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

    public List<Dice> getHand() {
        return hand;
    }

    public void drawDice() {
        shuffleDice();
        if (hand != null) {
            hand.forEach((Dice d) -> {
                dice.add(d);
                hand.remove(d);
            });
        }
        for (int i = 0; i < 5; i++) {
            int draw = rnd.nextInt(dice.size());
            Dice singleDice = dice.get(draw);
            hand.add(singleDice);
            dice.remove(singleDice);
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
        // TODO: 10/6/2017 Bolja imena za varijable da se lakse cita
        hand.forEach((d) -> {
            sb.append(d.toString()).append("\n");
        });
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result roll(List<Dice> selectedDice) {
        if (hand == null) {
            throw new IllegalStateException("No dice in hand.");
        }
        List<Side> sides = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sides.add(selectedDice.get(i).getSides().get(rnd.nextInt(6)));
        }

        // TODO: 10/6/2017 AA: Ovdje "Result result = new Result(); foreach side.accept(result)...
        return new Result(sides);
    }

    @Override
    public String toString() {
        // TODO: 10/6/2017 Ne znam jel dobro ime za varijablu, ne kontam bas sta je  
        String hand = this.hand.isEmpty() ? "no dice" : printHand();
        return String.format("%s with %s hp, %s armor and %s in hand", name, hp, shield, hand);
    }

}
