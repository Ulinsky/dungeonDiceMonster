package dice.player;

import dice.dice.Dice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private final List<Dice> dice;

    public Inventory() {
        this.dice = new ArrayList<>();
    }

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

}
