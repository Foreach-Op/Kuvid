package Domain.CollisionStrategy;

import Domain.Objects.GameObject;
import Domain.Objects.Shooter;
import Domain.Player.Player;
import Domain.Statistics.GameConfiguration;

public class ShooterBlockerCollision implements CollisionStrategy{
    @Override
    public void doCollision(GameObject object1, GameObject object2) {
        Player.getInstance().hit(object2.getPosition().getY()-object1.getPosition().getY());
        object2.destroy();
    }
}
