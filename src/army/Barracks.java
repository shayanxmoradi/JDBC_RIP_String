package army;

import java.util.ArrayList;
import java.util.List;

public class Barracks {
   static public Soldier[] soldiers ;

   public static Soldier[] getSoldiers() {
      return soldiers;
   }

   public static void setSoldiers(Soldier[] soldiers) {
      Barracks.soldiers = soldiers;
   }
}
