package dice;

public class Attack extends Side{

    int damage;
    
    public Attack(){
        this.damage = 1;
    }

    public Attack(int damage) {
        this.damage = damage;
    }

    @Override
    public int getValue() {
        return this.damage;
    } 
}
