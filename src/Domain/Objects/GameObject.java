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
    private MovementofObject movement;

    public GameObject() {
    }

    public GameObject(String type, String subType, Position position) {
        this.type = type;
        this.subType = subType;

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

    public Position getPosition() {
        return rect.getPosition();
    }

    public void setMovement(MovementofObject movement) {
        this.movement = movement;
    }

    public MovementofObject getMovement() {
        return movement;
    }

    public Rectangle getRectangle() {
        return rect;
    }

    public int getAngle() {
        return rect.getAngle();
    }

    public void setRectangle(Rectangle r) {
        this.rect = r;
    }

}
