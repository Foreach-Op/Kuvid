package UI;

import Domain.Objects.GameObject;
import Domain.Objects.Shooter;
import Domain.Useful.Position;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

public class GamePanel extends JPanel {
    public ConcurrentHashMap<GameObject, ObjectPanel> hashMap = new ConcurrentHashMap<>();
    public Shooter shooter;
    public GameObject triggerObject;
    private ObjectPanel triggerPanel;
    public GamePanel(){}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (ObjectPanel panel2:hashMap.values()) {
            panel2.draw(g);
            triggerPanel.draw(g);
        }
    }


    public void onCreate(GameObject obj) {
        ObjectPanel objectPanel = new ObjectPanel(obj.getType(), obj.getSubType(), obj.getCurrentPosition(),obj.getWidth(),obj.getHeight());
        hashMap.put(obj, objectPanel);
        if(obj.getType().equals("Shooter")){
            shooter=(Shooter) obj;

            triggerObject=shooter.getObjectInTrigger();
            triggerPanel=new ObjectPanel(triggerObject.getType(),triggerObject.getSubType(),triggerObject.getCurrentPosition(),triggerObject.getWidth(),triggerObject.getHeight());
            System.out.println(triggerObject.getX());
            //ObjectPanel triggerPanel = new ObjectPanel(triggerObject.getType(), triggerObject.getSubType(), triggerObject.getCurrentPosition(),triggerObject.getWidth(),triggerObject.getHeight());
            //hashMap.put(triggerObject,triggerPanel);
            System.out.println("Shooter added");
        }
        repaint();
    }


    public void onLocationChange() {
        for (GameObject object : hashMap.keySet()) {
            //if(object.equals(triggerObject)) continue;
            hashMap.get(object).updatePosition(object.getCurrentPosition());
            //System.out.print(object.getY()+" ");
            //System.out.println(shooter.getX());
        }
        repaint();
        //System.out.println(" ");
    }


    public void onDestroy(GameObject obj1, GameObject obj2) {
        removeFromScreen(obj1);
        removeFromScreen(obj2);
    }

    public void onShooterTriggerBulletChange() {
        triggerObject=shooter.getObjectInTrigger();
        triggerPanel = new ObjectPanel(triggerObject.getType(), triggerObject.getSubType(), triggerObject.getCurrentPosition(),triggerObject.getWidth(),triggerObject.getHeight());
        repaint();
    }


    public void onShooterPositionChange() {
        hashMap.get(shooter).updatePosition(shooter.getCurrentPosition());
        int x=(int) shooter.getX()+20;
        int y=(int) shooter.getY()-20;
        triggerPanel.updatePosition(new Position(x,y));
        repaint();
    }

    public void removeFromScreen(GameObject object) {
        if (!object.isAlive()) {
            ObjectPanel panel = hashMap.remove(object);
            repaint();
        }
    }
}
