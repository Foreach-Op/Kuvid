package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.HashMap;

public interface Collectable {
   public HashMap<Integer, HashMap<Subtype, Integer>> getCollected(); //0 for molecules, 1 for powerups
}
