package Domain.MovementStrategy;

import Domain.Objects.GameObject;
import Domain.Objects.MovementofObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Rectangle;

public class BlockerMovement implements MovementStrategy{
    @Override
    public void doMovement(GameObject obj) {

        double currentY=obj.getY();
        double yPos= obj.getVelocityY()* Math.sin(Math.toRadians(obj.getAngle()))+currentY;
        obj.setY(yPos);
        killObj(obj);
    }

    public void killObj(GameObject obj){
        int height=GameConfiguration.getInstance().getData().getGameScreenHeight();
        if(height<obj.getY()){
            obj.destroy();
        }
    }

}
