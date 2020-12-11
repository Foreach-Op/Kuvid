package UI;

import Domain.Objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

public class GamePanel extends JPanel {
    public ConcurrentHashMap<GameObject, ObjectPanel> hashMap = new ConcurrentHashMap<>();
    public GameObject shooter;
    public GamePanel(){}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (ObjectPanel panel2:hashMap.values()) {
            panel2.draw(g);
        }
    }


    public void onCreate(GameObject obj) {
        ObjectPanel objectPanel = new ObjectPanel(obj.getType(), obj.getSubType(), obj.getCurrentPosition(),obj.getWidth(),obj.getHeight());
        hashMap.put(obj, objectPanel);
        if(obj.getType().equals("Shooter")){
            shooter=obj;
            System.out.println("Shooter added");
        }
        repaint();
    }


    public void onLocationChange() {
        for (GameObject object : hashMap.keySet()) {
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


    /*
    public void onCreateShooter(GameObject shooter) {
        //this.shooter=shooter;
        //shooterPanel=new ObjectPanel2(shooter.getType(),shooter.getSubType(),shooter.getCurrentPosition());
        //repaint();
        onCreate(shooter);
    }

     */


    public void onShooterTriggerBulletChange() {

    }


    public void onShooterPositionChange() {
        hashMap.get(shooter).updatePosition(shooter.getCurrentPosition());
        System.out.println(shooter.getY());
        repaint();
    }

    public void removeFromScreen(GameObject object) {
        if (!object.isAlive()) {
            ObjectPanel panel = hashMap.remove(object);
            repaint();
        }
    }
}
