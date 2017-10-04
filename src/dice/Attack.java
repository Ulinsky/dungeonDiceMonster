package dice;

import visitor.Visitor;

public class Attack extends Side {

    int damage;

    public Attack() {
        this.damage = 1;
    }

    public Attack(int damage) {
        this.damage = damage;
    }

    @Override
    public int getValue() {
        return this.damage;
    }

    @Override
    public String getDesc() {
        return "Attack";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
