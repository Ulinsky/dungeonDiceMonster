package entity.enemy;

import dice.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Skeleton extends Enemy {

    public Skeleton() {
        super("Skeleton", 10, 15, 30);
        super.setDice(generateDice());
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void setShield(int shield) {
        super.setShield(shield);
    }

    @Override
    List<Dice> generateDice() {

        List<Dice> dice = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<Side> sides = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                sides.add(generateNewSide());
            }
            dice.add(new Dice(sides));
        }
        return dice;
    }

    private Side generateNewSide() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0:
                return new Attack(rnd.nextInt(3) + 1);
            case 2:
            case 1:
                return new Crit();
            case 3:
                return new Piercing();
            case 4:
                return new Shielding(rnd.nextInt(5) + 1);
            default:
                return null;
        }
    }
}

