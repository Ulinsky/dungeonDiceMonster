package dice.dice;

import dice.dice.Piercing;
import dice.dice.Side;
import dice.dice.Shielding;
import dice.dice.Healing;
import dice.dice.Crit;
import dice.dice.Attack;
import java.util.List;

public class Result {

    private int damage;
    private int damageCount;
    private int healing;
    private int shield;
    private boolean piercing;
    private boolean crit;
    private int critCount;
    private int piercingCount;

    public Result(List<Side> sides) {
        sides.forEach((Side s) -> {
            if (s instanceof Attack) {
                damage += s.getValue();
            } else if (s instanceof Healing) {
                healing += s.getValue();
            } else if( s instanceof Shielding) {
                shield += s.getValue();
            }
            if (s instanceof Crit) {
                crit = true;
                critCount++;
            }
            if (s instanceof Piercing) {
                piercing = true;
                piercingCount++;
            }
        });
       
        if(crit){
            damage *=2;
        }
    }

    public boolean isPiercing() {
        return piercing;
    }

    public boolean isCrit() {
        return crit;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealing() {
        return healing;
    }

    public int getShield() {
        return shield;
    }
    
    @Override
    public String toString() {     
        return String.format("\nA dice with %s damage,%s healing ,%s shielding, %s and %s piercing sides",damage,healing,shield,critCount,piercingCount);
    }
}
