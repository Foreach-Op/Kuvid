package Domain.Objects;

import UI.ObjectPanel;

public abstract class GameObject {
    public ObjectPanel objPanel;

    public void getDestroy(){

    }

    public void setPanel(ObjectPanel objPanel){
        this.objPanel=objPanel;
    }

    public void putOnScreen(){
        objPanel.addOnGameScreen();
    }


}
