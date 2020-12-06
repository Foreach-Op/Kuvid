package Domain.CollisionStrategy;

import Domain.Objects.GameObject;

public interface CollisionStrategy {

    void doCollision(GameObject object1, GameObject object2);
}
