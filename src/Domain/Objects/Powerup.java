package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.HashMap;

public class Powerup extends GameObject implements Fallable, Fireable, Collectable {
    public Powerup(Subtype type) {

        super();
        this.subType = type;
    }

    @Override
    public void collision(GameObject collider) {

    }

    @Override
    public HashMap<Integer, HashMap<Subtype, Integer>> getCollected() {

        HashMap<Integer, HashMap<Subtype, Integer>> mapToReturn = new HashMap<Integer, HashMap<Subtype, Integer>>();
        HashMap<Subtype, Integer> map = new HashMap<Subtype, Integer>();
        map.put(this.subType, 1);
        mapToReturn.put(1, map);
        return mapToReturn;
    }
}
