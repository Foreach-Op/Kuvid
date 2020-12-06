package Domain.TimerBased;

import Domain.Objects.GameObject;
import UI.ObjectPanel;

import java.util.ArrayList;

public class CollisionHandler {


    public CollisionHandler(ArrayList<GameObject> frameObjects) {
    }

    public void collisionDetect(){

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
