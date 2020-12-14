package Domain.Movement;

import Domain.Collision.Collision;
import Domain.Collision.CollisionStrategy;
import Domain.Collision.CollisionStrategyFactory;
import Domain.Objects.ObjectListener;
import Domain.Objects.GameObject;
import Domain.Utils.Position;
import Domain.Utils.Rectangle;

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
            MovementStrategy movementStrategy= MovementStrategyFactory.getStrategy(object);
            Movement movement=new Movement(movementStrategy);
            movement.executeMovement(object);
            frame.onLocationChange();
            //System.out.println("Movement Handler,move:"+object.getRectangle().getLocationX()+" "+object.getRectangle().getLocationY());
        }
    }

    public void collisionDetect(){
        for (int i=0;i<frameObjects.size();i++) {
            GameObject obj1= frameObjects.get(i);
            for (int j = i; j < frameObjects.size(); j++) {
                GameObject obj2= frameObjects.get(j);
                Rectangle rectangle1=new Rectangle(new Position((int) obj1.getX(),(int) obj1.getY()),obj1.getWidth(),obj2.getHeight(),0);
                Rectangle rectangle2=new Rectangle(new Position((int) obj2.getX(),(int) obj2.getY()),obj2.getWidth(),obj2.getHeight(),0);
                if(rectangle1.intersects(rectangle2)){
                    CollisionStrategy collisionStrategy= CollisionStrategyFactory.getStrategy(obj1,obj2);
                    if(collisionStrategy!=null){
                        Collision collision=new Collision(collisionStrategy);
                        collision.executeCollision(obj1,obj2);
                        if(!obj1.isAlive()){
                            frameObjects.remove(obj1);
                        }
                        if(!obj2.isAlive()){
                            frameObjects.remove(obj2);
                        }
                        frame.onDestroy(obj1,obj2);
                    }
                }
            }
        }
    }

}
