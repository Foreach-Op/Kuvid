package Domain.TimerBased;

import Domain.MovementStrategy.Movement;
import Domain.MovementStrategy.MovementStrategy;
import Domain.MovementStrategy.MovementStrategyFactory;
import Domain.Objects.GameObject;

import java.util.ArrayList;

public class MovementHandler {

    ArrayList<GameObject> frameObjects;

    public MovementHandler(ArrayList<GameObject> frameObjects) {
        this.frameObjects=frameObjects;
    }

    public void move(){
        for (GameObject object: frameObjects) {
            MovementStrategy movementStrategy= MovementStrategyFactory.getInstance().getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);
        }
    }

}
