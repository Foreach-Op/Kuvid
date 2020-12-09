package Domain.TimerBased;

import Domain.Objects.ObjectListener;
import Domain.MovementStrategy.Movement;
import Domain.MovementStrategy.MovementStrategy;
import Domain.MovementStrategy.MovementStrategyFactory;
import Domain.Objects.GameObject;

import java.util.ArrayList;

public class MovementHandler {

    private final ArrayList<GameObject> frameObjects;
    private final ObjectListener frame;

    public MovementHandler(ArrayList<GameObject> frameObjects,ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
    }

    public void move(){
        for (GameObject object: frameObjects) {
            MovementStrategy movementStrategy= MovementStrategyFactory.getInstance().getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);
            frame.onLocationChange();
            System.out.println("Movement Handler,move");
        }
    }

}
