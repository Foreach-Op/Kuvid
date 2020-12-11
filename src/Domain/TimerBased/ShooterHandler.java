package Domain.TimerBased;

import Domain.ObjectCreator.ObjectFactory;
import Domain.Objects.Alpha_Atom;
import Domain.Objects.GameObject;
import Domain.Objects.ObjectListener;
import Domain.Objects.Shooter;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

import static Domain.Useful.FinalValues.ATOM;


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
        //changeBullet();
        shooter.setY(GameConfiguration.getInstance().getData().getGameScreenHeight()-200);
        int x=(int) shooter.getX()+20;
        int y=(int) shooter.getY()-20;
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
            System.out.println("yeni X:"+xPos);
        } else if(direction.equals("left") && 0<currentX-shooter.getVelocityX()){
            xPos=currentX-shooter.getVelocityX();
        }
        //System.out.println("xPos: "+xPos+" YPos:"+currentY);
        Position newPos=new Position(xPos,currentY);
        newPos.setRotation(shooter.getRotationAngle());
        shooter.setCurrentPosition(newPos);
        frameListener.onShooterPositionChange();

    }

    public void fire(ObjectCreationHandler objectCreationHandler){
        int x=(int) shooter.getX()+20;
        int y=(int) shooter.getY()-20;
        objectCreationHandler.createGameObject(shooter.getCurrentBulletType(),shooter.getCurrentBulletSubtype(),new Position(x,y),false);
        shooter.reduceTheBullet();
        changeBullet();
    }

    public void rotateShooter(String direction) { //güncellenecek
        if(direction.equals("right")){
            shooter.setRotationAngle(shooter.getRotationAngle()+10);
            System.out.println("Burası");
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
        int x=(int) shooter.getX()+20;
        int y=(int) shooter.getY()-20;
        GameObject object=ObjectFactory.getInstance().createObject(ATOM,subtype,new Position(x,y),false);
        shooter.setObjectInTrigger(object);
        //shooter.setCurrentBulletType(ATOM);
        //shooter.setCurrentBulletSubtype(subtype);
        System.out.println(object.getType());
        frameListener.onShooterTriggerBulletChange();
    }

    public void changeBulletToPowerup(String subtype){ //change the bullet to desired type powerup object
        if(shooter.getNumOfBullets().get(FinalValues.POWERUP).get(subtype)>0) {
            shooter.setCurrentBulletType(FinalValues.POWERUP);
            shooter.setCurrentBulletSubtype(subtype);
        }
    }
}
