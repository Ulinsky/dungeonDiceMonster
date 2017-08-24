package dice;

public class Healing extends Side {

    int healing;

    public Healing() {
        this.healing = 1;
    }

    public Healing(int healing) {
        this.healing = healing;
    }

    @Override
    public int getValue() {
        return this.healing;
    }
}
