package Domain.MovementStrategy;

import Domain.Objects.GameObject;
import Domain.Objects.MovementofObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Rectangle;

public class MoleculeMovement implements MovementStrategy{
    @Override
    public void doMovement(GameObject obj) {
        obj.setRectangle(applyMovement(obj.getMovement(),obj.getRectangle()));
    }


    public Rectangle applyMovement(MovementofObject movement, Rectangle rectangle){
        //int gameWitdh=GameConfiguration.getInstance().getData().getGameScreenWidth();
        int gameWitdh=1000; // for demo purpose, delete after using
        if (rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY())> gameWitdh
                || rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY()) <0 ){
            if(movement.isReflectable()){
                movement.reflect();
            }
        }
        System.out.println(movement.getShiftX(rectangle.getLocationY()));
        System.out.println("aaa");
        rectangle.setLocationX(rectangle.getLocationX() + movement.getShiftX(rectangle.getLocationY()));
        System.out.println(rectangle.getLocationX());
        rectangle.setLocationY(rectangle.getLocationY() + movement.getShiftY(rectangle.getLocationY()));
        System.out.println(rectangle.getLocationY());
        rectangle.setAngle(rectangle.getAngle()+movement.getAngle());
        rectangle.setPointList(rectangle.getAngle());
        return rectangle;
    }
}
