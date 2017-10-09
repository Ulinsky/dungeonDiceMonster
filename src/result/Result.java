package result;

import dice.*;
import visitor.Visitor;

public class Result implements Visitor {

    private int damage = 0;
    private int healing = 0;
    private int shield = 0;
    private boolean piercing = false;
    private boolean crit = false;


    public boolean isPiercing() {
        return piercing;
    }

    public boolean isCrit() {
        return crit;
    }

    public int getDamage() {
        return crit ? damage * 2 : damage;
    }

    public int getHealing() {
        return healing;
    }

    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        return String.format("It did %s damage,%s healing %s shielding. \n%S \n%s", getDamage(), healing, shield, crit && damage > 0 ? "A critical strike!" : " ", piercing && damage > 0 ? "The damage pierced the enemy´s defences." : "");
    }

    @Override
    public void visit(Attack side) {
        this.damage += side.getValue();
    }

    @Override
    public void visit(Healing side) {
        this.healing += side.getValue();
    }

    @Override
    public void visit(Shielding side) {
        this.shield += side.getValue();
    }

    @Override
    public void visit(Crit side) {
        if (side.getValue() < 0) {
            this.crit = true;
        }
    }

    @Override
    public void visit(Piercing side) {
        if (side.getValue() < 0) {
            this.piercing = true;
        }
    }
}
