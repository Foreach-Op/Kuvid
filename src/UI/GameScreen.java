package UI;

import Domain.Objects.ObjectListener;
import Domain.Modes.RunningMode;
import Domain.Objects.GameObject;

import javax.swing.*;
import java.util.HashMap;

public class GameScreen extends JFrame implements ObjectListener {

    public HashMap<GameObject,ObjectPanel> hashMap=new HashMap<>();
    private StatisticsWindow statisticsWindow;

    public GameScreen(StatisticsWindow statisticsWindow){
        this.statisticsWindow=statisticsWindow;
        this.add(statisticsWindow);
    }

    public void addObjectPanel(ObjectPanel objectPanel) {
        this.add(objectPanel);
    }

    @Override
    public void onCreate(GameObject obj) {
        ObjectPanel objectPanel=new ObjectPanel(obj.getType(),obj.getSubType(),obj.position);
        hashMap.put(obj,objectPanel);
        this.add(objectPanel);
    }

    @Override
    public void onLocationChange() {
        for (GameObject object:hashMap.keySet()) {
            hashMap.get(object).updatePosition(object.position);
        }
    }

    @Override
    public void onDestroy(GameObject obj1, GameObject obj2) {
        removeFromScreen(obj1);
        removeFromScreen(obj2);
    }

    public void removeFromScreen(GameObject object){
        if(!object.isAlive()){
            ObjectPanel panel=hashMap.remove(object);
            this.remove(panel);
        }
    }

    public void initialize(RunningMode runningMode){
        runningMode.setFrame(this);
    }
}
