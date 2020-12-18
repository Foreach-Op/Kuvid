package Domain.Movement;

import Domain.Objects.ObjectListener;
import Domain.Objects.GameObject;

import java.util.HashMap;
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
            if(!object.isAlive()){
                frameObjects.remove(object);
                continue;
            }
            MovementStrategy movementStrategy= MovementStrategyFactory.getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);

        }
        frame.onLocationChange();
    }



}
