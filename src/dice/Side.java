package dice;

import visitor.Visitor;

public abstract class Side {
    public abstract int getValue();

    public abstract String getDesc();

    public abstract void accept(Visitor v);
}
