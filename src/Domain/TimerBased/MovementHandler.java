package Domain.TimerBased;

import Domain.Objects.ObjectListener;
import Domain.MovementStrategy.Movement;
import Domain.MovementStrategy.MovementStrategy;
import Domain.MovementStrategy.MovementStrategyFactory;
import Domain.Objects.GameObject;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MovementHandler {

    private final CopyOnWriteArrayList<GameObject> frameObjects;
    private final ObjectListener frame;

    public MovementHandler(CopyOnWriteArrayList<GameObject> frameObjects,ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
        //frameObjects.forEach(s-> System.out.println(s.getType()+" "+s.getSubType()));
    }

    public void move(){
        for (GameObject object: frameObjects) {
            //System.out.println("Movement Handler,move:"+object.getRectangle().getLocationX()+" "+object.getRectangle().getLocationY());
            MovementStrategy movementStrategy= MovementStrategyFactory.getInstance().getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);
            frame.onLocationChange();
            //System.out.println("Movement Handler,move:"+object.getRectangle().getLocationX()+" "+object.getRectangle().getLocationY());
        }
    }

}
