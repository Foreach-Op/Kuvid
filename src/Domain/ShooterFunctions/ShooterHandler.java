package Domain.ShooterFunctions;

import Domain.ObjectCreation.ObjectCreationHandler;
import Domain.ObjectCreation.ObjectFactory;
import Domain.Objects.*;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Utils.FinalValues;
import Domain.Utils.Position;

import static Domain.Utils.FinalValues.ATOM;
import static Domain.Utils.FinalValues.POWERUP;


public class ShooterHandler {

    private Shooter shooter;
    private ObjectListener frameListener;
    private static GameData gameData;


    public ShooterHandler(ObjectListener frameListener) {
        this.frameListener=frameListener;
        gameData = GameConfiguration.getInstance().getData();
    }

    public Shooter createShooter() {
        this.shooter=new Shooter();
        shooter.setCollectible(true);
        //changeBullet();
        shooter.setY(GameConfiguration.getInstance().getData().getGameScreenHeight()-200);
        int x=(int) shooter.getX()+shooter.getWidth()/3;
        int y=(int) shooter.getY()-shooter.getHeight()/4;
        shooter.setObjectInTrigger(new Alpha_Atom(new Position(x,y),90));
        frameListener.onCreate(shooter);
        GameConfiguration.getInstance().getData().setShooter(shooter);
        return shooter;
    }

    public Position setTriggerposition(String triggerType){

        int x=(int) shooter.getX()+shooter.getWidth()/3;
        int y=(int) shooter.getY()-shooter.getHeight()/4;
        if(triggerType.equals(POWERUP)){
            x=(int) shooter.getX();
            y=(int) shooter.getY()-shooter.getHeight()/2;
        }
        return new Position(x,y);
    }

    public void moveShooter(String direction){

        double currentX=shooter.getX();
        double currentY=shooter.getY();
        double xPos=0;

        if (direction.equals("right") && gameData.getGameScreenWidth()-gameData.getL()>currentX+shooter.getVelocityX()){
            xPos=currentX+shooter.getVelocityX();
        } else if(direction.equals("left") && 0<currentX-shooter.getVelocityX()){
            xPos=currentX-shooter.getVelocityX();
        }
        Position newPos=new Position(xPos,currentY);
        newPos.setRotation(shooter.getRotationAngle());
        shooter.setCurrentPosition(newPos);
        Position triggerPosition = setTriggerposition(shooter.getObjectInTrigger().getType());
        shooter.getObjectInTrigger().setCurrentPosition(triggerPosition);
        frameListener.onShooterPositionChange();

    }

    public void fire(ObjectCreationHandler objectCreationHandler){
        //System.out.println("burası çalıştı(shooterhandlerFire): "+((Atom)shooter.getObjectInTrigger()).isShielded());
        Position triggerPosition = setTriggerposition(shooter.getObjectInTrigger().getType());

        if(shooter.getObjectInTrigger().getType().equals(ATOM)){
            if (((Atom) shooter.getObjectInTrigger()).isShielded())
                GameConfiguration.getInstance().getData().getShieldedAtoms().remove(shooter.getObjectInTrigger());
        } else {
            triggerPosition.setY((int) shooter.getY()-shooter.getHeight());
        }

        shooter.getObjectInTrigger().setCurrentPosition(triggerPosition);
        GameObject fired=objectCreationHandler.createGameObject(shooter.getObjectInTrigger());
        fired.setAngle(90-shooter.getRotationAngle());
        shooter.reduceTheBullet();
        changeBullet();
        //System.out.println("burası çalıştı((shooterhandlerFire)-son): "+((Atom)shooter.getObjectInTrigger()).isShielded());
    }

    public void rotateShooter(String direction) {
        if(direction.equals("right") && shooter.getRotationAngle()<90){
            shooter.setRotationAngle(shooter.getRotationAngle()+10);
        } else{
            if(shooter.getRotationAngle()>-90){
                shooter.setRotationAngle(shooter.getRotationAngle()-10);
            }

        }
        frameListener.onShooterPositionChange();
    }

    public void changeBullet(){
        GameObject object=null;
        Position triggerPosition = setTriggerposition(ATOM);
        if((!GameConfiguration.getInstance().getData().getShieldedAtoms().isEmpty()) && (Math.random() * 4)<=1){ //şimdilik .25 ihtimal
            object=GameConfiguration.getInstance().getData().getShieldedAtoms().get(0);
            object.setCurrentPosition(triggerPosition);
        } else {
            String subtype = null;
            while (subtype == null) {
                int random = (int) (Math.random() * 4);
                if (random == 0) {
                    if (shooter.getNumOfAtoms().get(FinalValues.ALPHA) > 0) subtype = FinalValues.ALPHA;
                } else if (random == 1) {
                    if (shooter.getNumOfAtoms().get(FinalValues.BETA) > 0) subtype = FinalValues.BETA;
                } else if (random == 2) {
                    if (shooter.getNumOfAtoms().get(FinalValues.GAMMA) > 0) subtype = FinalValues.GAMMA;
                } else {
                    if (shooter.getNumOfAtoms().get(FinalValues.SIGMA) > 0) subtype = FinalValues.SIGMA;
                }
            }

            object = ObjectFactory.getInstance().createObject(ATOM, subtype,triggerPosition, false);
        }

        shooter.setObjectInTrigger(object);
        frameListener.onShooterTriggerBulletChange();
    }

    public void changeBulletToPowerup(String subtype){ //change the bullet to desired type powerup object
        if(shooter.getNumOfBullets().get(FinalValues.POWERUP).get(subtype)>0) {
            //shooter.setCurrentBulletType(FinalValues.POWERUP);
            //shooter.setCurrentBulletSubtype(subtype);
            Position triggerPosition = setTriggerposition(POWERUP);
            GameObject object=ObjectFactory.getInstance().createObject(POWERUP,subtype,triggerPosition,false);
            shooter.setObjectInTrigger(object);
            frameListener.onShooterTriggerBulletChange();
        }
    }


    public void addShield(String shieldType){
        if(shooter.getObjectInTrigger().getType().equals(POWERUP)) return;

        GameObject shieldedObj=null;
        Integer remaining=0;
        switch (shieldType){
            case FinalValues.ETA:
                remaining=GameConfiguration.getInstance().getRemainingShield(FinalValues.ETA);
                if(remaining>0)
                shieldedObj=add_Eta(shooter.getObjectInTrigger());
                break;
            case FinalValues.LOTA:
                remaining=GameConfiguration.getInstance().getRemainingShield(FinalValues.LOTA);
                if(remaining>0)
                shieldedObj=add_Lota(shooter.getObjectInTrigger());
                break;
            case FinalValues.THETA:
                remaining=GameConfiguration.getInstance().getRemainingShield(FinalValues.THETA);
                if(remaining>0)
                shieldedObj=add_Theta(shooter.getObjectInTrigger());
                break;
            case FinalValues.ZETA:
                remaining=GameConfiguration.getInstance().getRemainingShield(FinalValues.ZETA);
                if(remaining>0)
                shieldedObj=add_Zeta(shooter.getObjectInTrigger());
                break;
        }
        if(remaining>0){
            Position triggerPosition = setTriggerposition(ATOM);
            shieldedObj.setCurrentPosition(triggerPosition);
            shooter.setObjectInTrigger(shieldedObj);
            GameConfiguration.getInstance().setRemainingShield(shieldType);
            GameConfiguration.getInstance().getData().getShieldedAtoms().add(shieldedObj);
            frameListener.onShooterTriggerBulletChange();
        }


    }


    public GameObject add_Eta(GameObject obj){
        return new Eta_Shield((Atom) obj);
    }
    public GameObject add_Lota(GameObject obj){
        return new Lota_Shield((Atom) obj);
    }
    public GameObject add_Theta(GameObject obj){
        return new Theta_Shield((Atom) obj);
    }
    public GameObject add_Zeta(GameObject obj){
        return new Zeta_Shield((Atom) obj);
    }

}
