package Domain.Objects;

import Application.Modes.RunningMode;
import Domain.Listeners.ObjectListener;
import Domain.Useful.Subtype;

public abstract class GameObject {
    public ObjectListener objPanel;
    public Position position;
    protected String type;
    protected Subtype subType;
    //length
    //height
    //angle
    //rectangle
    //rectangle must be updated in where? in move, in other updateRectangle method, or in strategy pattern
    //will GameObject have length/height/angle/rectangle separately or just a rectangle that have all the other info?

    public void getDestroy(){
        RunningMode.getInstance().killObj(this);
        objPanel.onDestroy();
    }

    public abstract void collision(GameObject collider);

    public void updatePosition(){
        objPanel.onLocationChange();
    }

    public void setPanel(ObjectListener objPanel){
        this.objPanel=objPanel;
    }

    public void putOnScreen(){
        objPanel.addOnGameScreen();
    }

    public void move(int x,int y){
        //position.setX(position.getX()+10);
        position.setY(position.getY()+y);
        updatePosition();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Subtype getSubType() {
        return subType;
    }

    public void setSubType(Subtype subType) {
        this.subType = subType;
    }
}
