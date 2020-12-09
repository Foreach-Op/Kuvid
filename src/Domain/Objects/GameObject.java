package Domain.Objects;

//import Domain.Modes.RunningMode;
import Domain.Modes.RunningMode;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public abstract class GameObject {

    // To destroy object
    private boolean isAlive;
    private String type;
    private String subType;
    private Rectangle rect;


    public GameObject(){
    }

    public GameObject(String type,String subType, Position position){
        this.type=type;
        this.subType=subType;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void destroy() {
        isAlive = false;
    }
    public Position position() {
        return new Position(rect.getLocationX(), rect.getLocationY());
    }
}
