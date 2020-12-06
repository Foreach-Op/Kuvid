package Application.Modes;


import Domain.Objects.GameObject;
import Domain.Singletons.Player;
import UI.ObjectPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class RunningMode {
    private static RunningMode runningMode;
//
    private ArrayList<ObjectPanel> framePanels=new ArrayList<>();
    //can we create a singleton that have the frameObjects? So, we can use a common list from MovementHandler, CollisionHandler
    //and RunningMode without calling RunningMode.
    private ArrayList<GameObject> frameObjects =new ArrayList<>();

    private HashMap<String,HashMap<String,Integer>> fallableMap=new HashMap<>();
    private HashMap<String,HashMap<String,Integer>> fireableMap=new HashMap<>();

    public void addFrame(ObjectPanel panel){
        framePanels.add(panel);
    }
    //test
    public void addGameObject(ObjectPanel panel){
        framePanels.add(panel);
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

    // Move ve collision ayrı class da işlenecek
    /*public void move(){
        for (GameObject object: frameObjects) {
            object.setPosition(object.getPosition+ 7,5);
        }
    }*/

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

}
