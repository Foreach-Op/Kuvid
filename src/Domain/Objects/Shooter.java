package Domain.Objects;

import Domain.ObjectCreator.ObjectFactory;
import Domain.Statistics.GameConfiguration;
import Domain.TimerBased.ObjectCreationHandler;
import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

import java.util.HashMap;

import static Domain.Useful.FinalValues.ATOM;

public class Shooter extends GameObject {
    private int angle;
    private HashMap<String, HashMap<String, Integer>>  numOfBullets = new HashMap<String, HashMap<String, Integer>>();
    private String currentBulletType = null;
    private String currentBulletSubtype = null;//bullet of the shooter.
    public Rectangle rectangle;
    private MovementofObject leftMovement = MovementType.SHOOTER_MOVEMENT_LEFT.getMovement();
    private MovementofObject rightMovement = MovementType.SHOOTER_MOVEMENT_RIGHT.getMovement();
    private MovementofObject leftRotation = MovementType.SHOOTER_ROTATE_LEFT.getMovement();
    private MovementofObject rightRotation = MovementType.SHOOTER_ROTATE_RIGHT.getMovement();


    private static Shooter shooter;

    private Shooter(){
        super(null,null,new Position()); //poziyon atanacak
        initializeShooter();
    }

    public static Shooter getInstance(){
        if(shooter ==null){
            shooter =new Shooter();
        }
        return shooter;
    }

    public void initializeShooter(){
        initializeBullets();
        rectangle=new Rectangle(5,5,5,5,5); //düzelt
    }


    public void collision(GameObject collider) {

    }

    public void initializeBullets(){
        numOfBullets = getAmmunition();
    }

    public void changeBulletToPowerup(String subtype){ //change the bullet to desired type powerup object
        if(numOfBullets.get(FinalValues.POWERUP).get(subtype)>0) {
         currentBulletType = FinalValues.POWERUP;
         currentBulletSubtype = subtype;
        }
    }

    public GameObject fire(){
        GameObject fired = ObjectFactory.getInstance().createFireableObject(currentBulletType,currentBulletSubtype,angle);
        reduceTheBullet();
        changeBullet();
        return fired;
    }

    public void reduceTheBullet(){ // reduce the number of bullet in the fire operation
        numOfBullets.get(currentBulletType).replace(currentBulletSubtype,
                numOfBullets.get(currentBulletType).get(currentBulletSubtype)-1);
        setAmmunition(numOfBullets);
    }
    public void changeBullet(){ // randomly change bullet to different kind of atoms
        String subtype = null;
        while (subtype == null) {
            int random = (int) (Math.random() * 4);
            if (random == 0) {if (getNumOfAtoms().get(FinalValues.ALPHA) > 0) subtype = FinalValues.ALPHA;}
                else if (random == 1){ if(getNumOfAtoms().get(FinalValues.BETA)>0) subtype =FinalValues.BETA;}
                else if (random == 2){ if(getNumOfAtoms().get(FinalValues.GAMMA)>0) subtype =FinalValues.GAMMA;}
                else {if(getNumOfAtoms().get(FinalValues.SIGMA)>0) subtype =FinalValues.SIGMA;}
            }
        currentBulletType = ATOM;
        currentBulletSubtype = subtype;
    }

    public HashMap<String, HashMap<String, Integer>> getNumOfBullets() {
        return numOfBullets;
    }
    public HashMap<String, Integer> getNumOfAtoms(){
        return numOfBullets.get(ATOM);
    }
    public void setNumOfAtoms(HashMap<String, Integer> set){
        numOfBullets.replace(ATOM, set);
        setAmmunition(numOfBullets);
    }

    public void collect(Collectable c){
        String type = c.getCollected()[0];
        String subtype = c.getCollected()[1];
        System.out.println(type);
        numOfBullets.get(type).replace(subtype, numOfBullets.get(type).get(subtype)+1);
        setAmmunition(numOfBullets);
    }

    public HashMap<String, HashMap<String, Integer>> getAmmunition(){
        return GameConfiguration.getInstance().getData().getAmmunition();
    }

    public void setAmmunition(HashMap<String, HashMap<String, Integer>> numOfBullets){
        GameConfiguration.getInstance().getData().setAmmunition(numOfBullets);
    }


}
