package Domain.Movement;

import Domain.Objects.ObjectListener;
import Domain.Objects.GameObject;

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
            if(object.equals(frameObjects.get(0))) continue;
            //System.out.println("Movement Handler,move:"+object.getRectangle().getLocationX()+" "+object.getRectangle().getLocationY());
            MovementStrategy movementStrategy= MovementStrategyFactory.getInstance().getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);
            frame.onLocationChange();
            //System.out.println("Movement Handler,move:"+object.getRectangle().getLocationX()+" "+object.getRectangle().getLocationY());
        }
    }

}
