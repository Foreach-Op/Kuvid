package Domain.TimerBased;

import Domain.CollisionStrategy.Collision;
import Domain.CollisionStrategy.CollisionStrategy;
import Domain.CollisionStrategy.CollisionStrategyFactory;
import Domain.Listeners.ObjectListener;
import Domain.Objects.GameObject;
import UI.ObjectPanel;

import java.util.ArrayList;

public class CollisionHandler {

    private final ArrayList<GameObject> frameObjects;
    private final ObjectListener frame;

    public CollisionHandler(ArrayList<GameObject> frameObjects, ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
    }

    public void collisionDetect(){
        for (int i=0;i<frameObjects.size();i++) {
            GameObject obj1= frameObjects.get(i);
            for (int j = i; j < frameObjects.size(); j++) {
                GameObject obj2= frameObjects.get(j);
                if(true){
                    CollisionStrategy collisionStrategy= CollisionStrategyFactory.getInstance().getStrategy(obj1,obj2);
                    Collision collision=new Collision(collisionStrategy);
                    collision.executeCollision(obj1,obj2);
                    frame.onDestroy(obj1,obj2);
                }
                //if(current.getBounds().intersects(temp.getBounds())){
                //    frameObjects.get(i).collision(frameObjects.get(j));
                //}
            }
        }
    }




    /*
    public void collisionDetect(){

        for (int i=0;i<framePanels.size();i++) {
            ObjectPanel current= framePanels.get(i);
            for (int j = i; j < frameObjects.size(); j++) {
                ObjectPanel temp= framePanels.get(j);
                if(current.getBounds().intersects(temp.getBounds())){
                    frameObjects.get(i).collision(frameObjects.get(j));
                }
            }
        }
    }



    public void killObj(GameObject gameObject) {
        int index=-1;
        for (int i = 0; i < frameObjects.size(); i++) {
            if(frameObjects.get(i).equals(gameObject))
                index=i;
        }
        if(index!=-1){
            frameObjects.remove(index);
            framePanels.remove(index);
            notifyAll();
        }
    }

     */


}
