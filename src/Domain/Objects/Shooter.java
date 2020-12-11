package Domain.Objects;

import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

import java.util.HashMap;

import static Domain.Useful.FinalValues.ATOM;

public class Shooter extends GameObject {
    private HashMap<String, HashMap<String, Integer>>  numOfBullets;
    private String currentBulletType = null;
    private String currentBulletSubtype = null;//bullet of the shooter.
    private GameObject objectInTrigger=null;
    public Rectangle rectangle;

    private static GameData gameData=GameConfiguration.getInstance().getData();

    public Shooter() {
        super("Shooter","1",new Position(500,500),90,false);
        numOfBullets=GameConfiguration.getInstance().getData().getAmmunition();
        //super("Shooter","1",new Position(gameData.getGameScreenWidth()/2 - (gameData.getL()/2),
        //        gameData.getGameScreenHeight()-gameData.getL()),90);
        setVelocity(new Position(10,0));
        setHeight(getL());
        setWidth(getL()/2);
        initializeShooter();
    }

    public void setRotationAngle(int rotationAngle){
        getCurrentPosition().setRotation(rotationAngle);
    }

    public int getRotationAngle(){
        return getCurrentPosition().getRotation();
    }

    public void initializeShooter(){
        initializeBullets();
        rectangle=new Rectangle(super.getCurrentPosition(),getL(),getL(),90); //düzelt, angle neye göre? o düzelilsin
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

    public GameObject getObjectInTrigger() {
        return objectInTrigger;
    }

    public void setObjectInTrigger(GameObject objectInTrigger) {
        this.currentBulletType=objectInTrigger.getType();
        this.currentBulletSubtype=objectInTrigger.getSubType();
        this.objectInTrigger = objectInTrigger;
    }

    public String getCurrentBulletType() {
        return currentBulletType;
    }

    public String getCurrentBulletSubtype() {
        return currentBulletSubtype;
    }

    public void setCurrentBulletType(String currentBulletType) {
        this.currentBulletType = currentBulletType;
    }

    public void setCurrentBulletSubtype(String currentBulletSubtype) {
        this.currentBulletSubtype = currentBulletSubtype;
    }

    public void reduceTheBullet(){ // reduce the number of bullet in the fire operation
        numOfBullets.get(currentBulletType).replace(currentBulletSubtype,
                numOfBullets.get(currentBulletType).get(currentBulletSubtype)-1);
        GameConfiguration.getInstance().setAmmunition(numOfBullets);
        //setAmmunition(numOfBullets);
    }
    /*
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

     */

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

    public HashMap<String, HashMap<String, Integer>> getAmmunition(){
        return GameConfiguration.getInstance().getData().getAmmunition();
    }

    public void setAmmunition(HashMap<String, HashMap<String, Integer>> numOfBullets){
        GameConfiguration.getInstance().getData().setAmmunition(numOfBullets);
    }


}
