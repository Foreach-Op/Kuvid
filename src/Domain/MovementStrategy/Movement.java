package Domain.MovementStrategy;

import Domain.Objects.GameObject;

public class Movement {

    private MovementStrategy movementStrategy;

    public Movement(MovementStrategy movementStrategy){
        this.movementStrategy=movementStrategy;
    }

    public void executeMovement(GameObject obj){
        movementStrategy.doMovement(obj);
    }
}
