package entity.enemy;

import dice.Dice;
import dice.Side;
import result.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Enemy {

    private String name;
    private int hp;
    private int shield;
    private List<Dice> dice;
    private List<Dice> hand;
    private int initiative;
    private final int maxHp;
    private final int maxShield;
    Random rnd;

    public Enemy(String name, int hp, int shield, int initiative) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.maxShield = shield;
        this.shield = shield;
        this.initiative = initiative;
        this.dice = new ArrayList<>();
        this.hand = new ArrayList<>();
        rnd = new Random();
        generateDice();

    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp > maxHp) {
            this.hp = maxHp;
        }
    }

    public void setShield(int shield) {
        this.shield = shield;
        if (this.shield > maxShield) {
            this.shield = maxShield;
        }
    }

    public int getShield() {
        return shield;
    }


    public List<Dice> getHand() {
        return hand;
    }

    public int getInitiative() {
        return initiative;
    }

    public String printHand() {
        StringBuilder sb = new StringBuilder("\n");
        hand.forEach((d) -> {
            sb.append(d.toString()).append("\n");
        });
        return sb.toString();
    }

    public void setDice(List<Dice> dice) {
        this.dice = dice;
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

    public void shuffleDice() {
        Collections.shuffle(dice);
    }

    @Override
    public String toString() {
        return String.format("%s with %s hp, %s armor", name, hp, shield);
    }

    public void addDice(Dice dice) {
        this.dice.add(dice);
    }

    abstract List<Dice> generateDice();

    public Result roll() {
        if (hand == null) {
            throw new IllegalStateException("No dice in hand.");
        }
        List<Side> sides = new ArrayList<>();
        int[] numbers = new Random().ints(0, 5).distinct().limit(3).toArray();
        for (int i = 0; i < 3; i++) {
            sides.add(hand.get(numbers[i]).getSides().get(rnd.nextInt(6)));
        }
        Result r = new Result();
        for (Side s : sides) {
            s.accept(r);
        }
        return r;
    }
}
