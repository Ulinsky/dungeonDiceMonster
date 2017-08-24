package dice.dice;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Dice {

    
    private final List<Side> sides;

    public Dice(List<Side> sides) {
        this.sides = sides;
    }

    public List<Side> getSides() {
        return sides;
    }

    public Side roll() {
        Random rnd = new Random();
        return sides.get(rnd.nextInt(5));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sides.forEach(new Consumer<Side>() {
            @Override
            public void accept(Side s) {
               // i++;
                sb.append(i).append(": ").append(s.getClass()).append(" ").append(s.getValue() > 0? s.getValue():"").append("\n");
            }
        });
      return sb.toString();
    }

}
