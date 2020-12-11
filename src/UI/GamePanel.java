package UI;

import Domain.Objects.GameObject;
import Domain.Objects.ObjectListener;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

public class GamePanel extends JPanel {
    public ConcurrentHashMap<GameObject, ObjectPanel2> hashMap = new ConcurrentHashMap<>();
    public GameObject shooter;
    public GamePanel(){
        //this.frame=frame;
        //Container animContainer = frame.getContentPane();
        //animContainer.add(this);
        //frame.setSize(1000, 1000);
        //frame.setLocation(0,100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (ObjectPanel2 panel2:hashMap.values()) {
            panel2.draw(g);
        }
    }


    public void onCreate(GameObject obj) {
        ObjectPanel2 objectPanel2 = new ObjectPanel2(obj.getType(), obj.getSubType(), obj.getCurrentPosition());
        //System.out.println("Created");
        hashMap.put(obj, objectPanel2);
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
            //gamePanel.repaint();
            //System.out.println(shooter.getX());
        }
        repaint();
        //System.out.println(" ");
    }


    public void onDestroy(GameObject obj1, GameObject obj2) {
        removeFromScreen(obj1);
        removeFromScreen(obj2);
    }


    public void onCreateShooter(GameObject shooter) {
        //this.shooter=shooter;
        //shooterPanel=new ObjectPanel2(shooter.getType(),shooter.getSubType(),shooter.getCurrentPosition());
        //repaint();
        onCreate(shooter);
    }


    public void onShooterTriggerBulletChange() {

    }


    public void onShooterPositionChange() {
        hashMap.get(shooter).updatePosition(shooter.getCurrentPosition());
        System.out.println(shooter.getY());
        repaint();
    }

    public void removeFromScreen(GameObject object) {
        if (!object.isAlive()) {
            ObjectPanel2 panel = hashMap.remove(object);
            repaint();
        }

    }
}
