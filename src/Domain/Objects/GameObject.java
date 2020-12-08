package Domain.Objects;

//import Domain.Modes.RunningMode;
import Domain.Useful.Position;

public abstract class GameObject {
    public Position position;
    // To destroy object
    private boolean isAlive;
    private String type;
    private String subType;
    //rectangle buraya gelecek


    public GameObject(){

    }

    public GameObject(String type,String subType,Position position){
        this.position=position;
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
}
