package dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player test = new Player();
        test.setName("Trole");
        for (int i = 0; i < 30; i++) {
            List<Side> dices = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                dices.add(generateNewSide());
            }
            test.addDice(new Dice(dices));
        }
        System.out.println(test);
        test.drawDice();
        System.out.println(test);

//       List<Side> sides = new ArrayList<>();
//       sides.add(new Attack(2));
//       sides.add(new Attack(2));
//       sides.add(new Attack(2));
//       sides.add(new Attack(3));
//       sides.add(new Attack(3));
//       sides.add(new Crit());
//       Dice midTierAttack = new Dice(sides);
//       
//        System.out.println(midTierAttack);
       
   }

    public static Side generateNewSide() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0:
                return new Attack();
            case 1:
                return new Crit();
            case 2:
                return new Healing();
            case 3:
                return new Piercing();
            case 4:
                return new Shielding();
            default:
                return null;
        }
    }
}
