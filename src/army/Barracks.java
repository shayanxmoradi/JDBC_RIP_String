package army;

import java.util.ArrayList;
import java.util.List;

public class Barracks {
   static public List<Soldier> soldiers = new ArrayList<Soldier>();

   public static List<Soldier> getSoldiers() {
      return soldiers;
   }

   public static void setSoldiers(List<Soldier> soldiers) {
      Barracks.soldiers = soldiers;
   }
}
