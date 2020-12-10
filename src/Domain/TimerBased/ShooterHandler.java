package Domain.TimerBased;

import Domain.Objects.ObjectListener;
import Domain.Objects.Shooter;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Useful.Position;


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
        frameListener.onCreateShooter(shooter);
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

        Position newPos=new Position(xPos,currentY);
        shooter.setCurrentPosition(newPos);
        frameListener.onLocationChange();

    }

    public void fire(){

    }

    public void rotateShooter(String direction) {
    }

    public void pickAtom() {
    }
}
