package dice;


import visitor.Visitor;

public class Piercing extends Side {

    @Override
    public int getValue() {
        return -1;
    }

    @Override
    public String getDesc() {
        return "Piercing";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
