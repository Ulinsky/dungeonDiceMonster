package visitor;

import dice.*;

public interface Visitor {
    void visit(Attack side);

    void visit(Healing side);

    void visit(Shielding side);

    void visit(Crit side);

    void visit(Piercing side);
}
