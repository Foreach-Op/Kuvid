package Domain.Objects;

//import Domain.Modes.RunningMode;
import Domain.Listeners.ObjectListener;
import Domain.Useful.Rectangle;
import Domain.Useful.Subtype;

public abstract class GameObject {
    //Position
    //movementPerFrame(+-y,+-x)
    public Position position;
    public Rectangle rectangle;
    public MovementofObject movementofObject;

    //bu ikisi silinecek gibi ya da bilgi olarak tutulacak sadece
    private String type;
    private String subType;


    public GameObject(){}

    public GameObject(String type,String subType){
        this.type=type;
        this.subType=subType;
    }
    //protected String type;
    //protected Subtype subType;
    //length
    //height
    //angle
    //rectangle
    //rectangle must be updated in where? in move, in other updateRectangle method, or in strategy pattern
    //will GameObject have length/height/angle/rectangle separately or just a rectangle that have all the other info?

    /*
    bu yorumdakiler silinecek static yapılacak objectler,

    public void getDestroy(){
        // RunningMode.getInstance().killObj(this);
        //objPanel.onDestroy();
    }

 */

    //dışardan yönetilecek gerek yok, ama şimdilik dursun
    public void move(int x,int y){
        //position.setX(position.getX()+10);
        position.setY(position.getY()+y);
        //updatePosition();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
