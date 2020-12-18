package Domain.Collision;

import Domain.Movement.Movement;
import Domain.Movement.MovementStrategy;
import Domain.Objects.ObjectListener;
import Domain.Objects.GameObject;
import Domain.Utils.FinalValues;
import Domain.Utils.Position;
import Domain.Utils.Rectangle;


import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollisionHandler {

    private final CopyOnWriteArrayList<GameObject> frameObjects;
    private final ObjectListener frame;
    private HashMap<String, HashMap<String, CollisionStrategy>> strategyMap;

    public CollisionHandler(CopyOnWriteArrayList<GameObject> frameObjects, ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
        initializeStrategyMap();
    }
    public void initializeStrategyMap(){
        strategyMap = new HashMap<String, HashMap<String, CollisionStrategy>>();
        HashMap<String, CollisionStrategy> moleculeStrategies = new HashMap<String, CollisionStrategy>();
        moleculeStrategies.put(FinalValues.ATOM, new AtomMoleculeCollision());
        strategyMap.put(FinalValues.MOLECULE, moleculeStrategies);
        HashMap<String, CollisionStrategy> blockerStrategies = new HashMap<String, CollisionStrategy>();
        blockerStrategies.put(FinalValues.MOLECULE, new BlockerAtomMoleculeCollision());
        blockerStrategies.put(FinalValues.ATOM, new BlockerAtomMoleculeCollision());
        blockerStrategies.put(FinalValues.POWERUP, new BlockerPoweupCollision());
        strategyMap.put(FinalValues.BLOCKER, blockerStrategies);
        HashMap<String, CollisionStrategy> shooterStrategies = new HashMap<String, CollisionStrategy>();
        shooterStrategies.put(FinalValues.POWERUP, new ShooterPowerupCollision());
        shooterStrategies.put(FinalValues.BLOCKER, new ShooterBlockerCollision());
        strategyMap.put(FinalValues.SHOOTER, shooterStrategies);
    }

    public void collisionDetect(){
        for (int i=0;i<frameObjects.size();i++) {
            GameObject obj1= frameObjects.get(i);
            for (int j = i; j < frameObjects.size(); j++) {
                GameObject obj2= frameObjects.get(j);
                Rectangle rectangle1=new Rectangle(new Position((int) obj1.getX(),(int) obj1.getY()),obj1.getWidth(),obj2.getHeight(),0);
                Rectangle rectangle2=new Rectangle(new Position((int) obj2.getX(),(int) obj2.getY()),obj2.getWidth(),obj2.getHeight(),0);
                if(rectangle1.intersects(rectangle2)){
                    if (strategyMap.get(obj1.getType())!= null){
                        CollisionStrategy collisionStrategy= strategyMap.get(obj1.getType()).get(obj2.getType());
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
                    }}
                    }
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
