package Domain.Movement;

import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Utils.Position;

public class AlphaMoleculeMovement implements MovementStrategy{
    @Override
    public void doMovement(GameObject obj) {

        changeTheVelocity(obj);

        double currentX=obj.getX();
        double currentY=obj.getY();
        //Sorun çözülecek
        double xPos=obj.getVelocityX()* Math.cos(Math.toRadians(obj.getAngle()))+currentX;
        double yPos= obj.getVelocityY()* Math.sin(Math.toRadians(obj.getAngle()))+currentY;
        //System.out.print(obj.getType()+" "+obj.getSubType()+" "+ obj.getAngle()+" ");
        Position newPos=new Position(xPos,yPos);
        obj.setCurrentPosition(newPos);

        //obj.setX(xPos);
        //obj.setY(yPos);
        //System.out.println(obj.getType()+" "+obj.getSubType()+" "+obj.getY());
        killObj(obj);
    }

    private void changeTheVelocity(GameObject obj){
        if((int) (obj.getY()%PositionLimit)==PositionLimit-1){
            obj.setVelocityX(-obj.getVelocityX());
        }
    }
    public void killObj(GameObject obj){
        if(GameConfiguration.getInstance().getData().getGameScreenHeight()<=obj.getY()){
            obj.destroy();
        }
    }
}
