package dice;

import java.util.List;
import java.util.Random;

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
        for (Side s : sides) {
            sb.append(": ").append(s.getDesc()).append(" ").append(s.getValue() > 0 ? s.getValue() : "").append("\n");
        }
        return sb.toString();
    }

}
