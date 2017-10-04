package dice;

import visitor.Visitor;

public class Shielding extends Side {

    int shield;

    public Shielding() {
        this.shield = 1;
    }

    public Shielding(int shielding) {
        this.shield = shielding;
    }

    @Override
    public int getValue() {
        return this.shield;
    }

    @Override
    public String getDesc() {
        return "Shielding";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
