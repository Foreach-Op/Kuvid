package Domain.Collision;

import Domain.Objects.GameObject;
import Domain.Player.Player;

public class ShooterBlockerCollision implements CollisionStrategy{
    @Override
    public void doCollision(GameObject object1, GameObject object2) {
        Player.getInstance().hit((int) (object2.getCurrentPosition().getY()-object1.getCurrentPosition().getY()));
        object2.destroy();
    }
}
