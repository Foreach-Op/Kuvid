package Domain.MovementStrategy;

import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Position;

public class AlphaMoleculeMovement implements MovementStrategy{
    @Override
    public void doMovement(GameObject obj) {

        changeTheVelocity(obj);

        double currentX=obj.getX();
        double currentY=obj.getY();
        double xPos=obj.getVelocityX()* Math.cos(obj.getAngle())+currentX;
        double yPos= obj.getVelocityY()* Math.sin(obj.getAngle())+currentY;
        //System.out.print(obj.getType()+" "+obj.getSubType()+" "+ obj.getAngle()+" ");
        Position newPos=new Position(xPos,yPos);
        obj.setCurrentPosition(newPos);
        //obj.setX(xPos);
        //obj.setY(yPos);
        //System.out.println(obj.getType()+" "+obj.getSubType()+" "+obj.getY());
        killObj(obj);
    }

    private void changeTheVelocity(GameObject obj){
        if((int) obj.getY()%PositionLimit==0){
            obj.setVelocityX(-obj.getVelocityX());
        }
    }
    public void killObj(GameObject obj){
        if(GameConfiguration.getInstance().getData().getGameScreenHeight()<=obj.getY()){
            obj.destroy();
        }
    }
}
