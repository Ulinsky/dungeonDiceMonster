package dice;

import visitor.Visitor;

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

    @Override
    public String getDesc() {
        return "Healing";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
