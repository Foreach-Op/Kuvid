package Domain.MovementStrategy;

import Domain.Objects.GameObject;
import Domain.Objects.MovementofObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Rectangle;

public class BlockerMovement implements MovementStrategy{
    @Override
    public void doMovement(GameObject obj) {
        applyMovement(obj.getMovement(),obj.getRectangle());
    }


    public void applyMovement(MovementofObject movement, Rectangle rectangle){
        if (rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY())> GameConfiguration.getInstance().getData().getGameScreenWidth()
                || rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY()) <0 ){
            if(movement.isReflectable()){
                movement.reflect();
            }
        }
        rectangle.setLocationX(rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY()));
        rectangle.setLocationY(rectangle.getLocationY() + movement.getShiftY(rectangle.getLocationY()));
        rectangle.setAngle(rectangle.getAngle()+movement.getAngle());
        rectangle.setPointList(rectangle.getAngle());
    }
}
