package dice;

import visitor.Visitor;

public class Crit extends Side {

    @Override
    public int getValue() {
        return -1;
    }

    @Override
    public String getDesc() {
        return "Crit";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
