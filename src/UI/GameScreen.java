package UI;

import Domain.Listeners.ObjectListener;
import Domain.Objects.GameObject;
import Domain.Objects.Position;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

public class GameScreen extends JFrame implements ObjectListener {

    public HashMap<GameObject,ObjectPanel> hashMap=new HashMap<>();

    public GameScreen(){}

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
    public void addOnGameScreen() {

    }

    @Override
    public void onLocationChange() {
        for (GameObject object:hashMap.keySet()) {
            hashMap.get(object).updatePosition(object.position);
        }
    }

    @Override
    public void onDestroy(List<GameObject> objects) {
        for (GameObject object:objects) {
            ObjectPanel panel=hashMap.remove(object);
            this.remove(panel);
        }
    }
}
