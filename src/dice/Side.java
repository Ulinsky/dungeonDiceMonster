package dice;

import visitor.Element;
import visitor.Visitor;

public abstract class Side implements Element {
    public abstract int getValue();

    public abstract String getDesc();

    public abstract void accept(Visitor v);
}
