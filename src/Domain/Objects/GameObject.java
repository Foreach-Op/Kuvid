package Domain.Objects;

import Application.Modes.RunningMode;
import Domain.Listeners.ObjectListener;
import UI.ObjectPanel;

public abstract class GameObject {
    public ObjectListener objPanel;
    public Position position;
    protected String type;
    protected String subType;

    public void getDestroy(){
        RunningMode.getInstance().killObj(this);
    }

    public void updatePosition(){
        objPanel.changeLocation(position);
    }

    public void setPanel(ObjectPanel objPanel){
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


}
