package Domain.Collision;

import Domain.Objects.GameObject;

public class PowerupBlockerCollision implements CollisionStrategy{
    @Override
    public void doCollision(GameObject object1, GameObject object2) {
        if(object1.getSubType().equals(object2.getSubType())){
            object2.destroy();
        }
        object1.destroy();
    }
}
