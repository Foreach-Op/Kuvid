package Domain.ShooterFunctions;

import Domain.ObjectCreator.ObjectCreationHandler;
import Domain.ObjectCreator.ObjectFactory;
import Domain.Objects.Alpha_Atom;
import Domain.Objects.GameObject;
import Domain.Objects.ObjectListener;
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
        return shooter;
    }

    public void moveShooter(String direction){

        double currentX=shooter.getX();
        double currentY=shooter.getY();
        //şu anda her talepte L kadar gidecek
        double xPos=0;

        if (direction.equals("right") && gameData.getGameScreenWidth()-gameData.getL()>currentX+shooter.getVelocityX()){
            xPos=currentX+shooter.getVelocityX();
        } else if(direction.equals("left") && 0<currentX-shooter.getVelocityX()){
            xPos=currentX-shooter.getVelocityX();
        }

        Position newPos=new Position(xPos,currentY);
        newPos.setRotation(shooter.getRotationAngle());
        shooter.setCurrentPosition(newPos);
        frameListener.onShooterPositionChange();

    }

    public void fire(ObjectCreationHandler objectCreationHandler){
        int x=(int) shooter.getX()+shooter.getWidth()/3;
        int y=(int) shooter.getY()-shooter.getHeight()/4;
        if(shooter.getCurrentBulletType().equals("Powerup")){
            x=(int) shooter.getX()+0;
            y=(int) shooter.getY()-shooter.getHeight();
        }

        GameObject fired=objectCreationHandler.createGameObject(shooter.getCurrentBulletType(),shooter.getCurrentBulletSubtype(),new Position(x,y),false);
        fired.setAngle(90-shooter.getRotationAngle());
        shooter.reduceTheBullet();
        changeBullet();
    }

    public void rotateShooter(String direction) {
        if(direction.equals("right")){
            shooter.setRotationAngle(shooter.getRotationAngle()+10);
        } else{
            shooter.setRotationAngle(shooter.getRotationAngle()-10);
        }
        frameListener.onShooterPositionChange();
    }

    public void changeBullet(){ // need to update UI
        String subtype = null;
        while (subtype == null) {
            int random = (int) (Math.random() * 4);
            if (random == 0) {if (shooter.getNumOfAtoms().get(FinalValues.ALPHA) > 0) subtype = FinalValues.ALPHA;}
            else if (random == 1){ if(shooter.getNumOfAtoms().get(FinalValues.BETA)>0) subtype =FinalValues.BETA;}
            else if (random == 2){ if(shooter.getNumOfAtoms().get(FinalValues.GAMMA)>0) subtype =FinalValues.GAMMA;}
            else {if(shooter.getNumOfAtoms().get(FinalValues.SIGMA)>0) subtype =FinalValues.SIGMA;}
        }
        int x=(int) shooter.getX()+shooter.getWidth()/3;
        int y=(int) shooter.getY()-shooter.getHeight()/4;
        GameObject object=ObjectFactory.getInstance().createObject(ATOM,subtype,new Position(x,y),false);
        shooter.setObjectInTrigger(object);
        //shooter.setCurrentBulletType(ATOM);
        //shooter.setCurrentBulletSubtype(subtype);
        //System.out.println(object.getType());
        frameListener.onShooterTriggerBulletChange();
    }

    public void changeBulletToPowerup(String subtype){ //change the bullet to desired type powerup object
        if(shooter.getNumOfBullets().get(FinalValues.POWERUP).get(subtype)>0) {
            shooter.setCurrentBulletType(FinalValues.POWERUP);
            shooter.setCurrentBulletSubtype(subtype);
            int x=(int) shooter.getX();
            int y=(int) shooter.getY()-shooter.getHeight()/2;
            GameObject object=ObjectFactory.getInstance().createObject(POWERUP,subtype,new Position(x,y),false);
            shooter.setObjectInTrigger(object);
            frameListener.onShooterTriggerBulletChange();
        }
    }
}
