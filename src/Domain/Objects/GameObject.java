package Domain.Objects;

//import Domain.Modes.RunningMode;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public abstract class GameObject {

    private boolean isAlive;
    private String type;
    private String subType;
    //private Rectangle rect;
    private Position currentPosition;
    private double heightCoef;
    private double widthCoef;
    private Position velocity;
    private int angle;
    private boolean isFallable;


    public GameObject() {
    }

    public GameObject(String type, String subType, Position position,int angle) {
        this.type = type;
        this.subType = subType;
        this.currentPosition=position;
        this.angle=angle;
        velocity =new Position(1,1);
        //this.rect=new Rectangle(position,widthCoef,heightCoef,angle);
    }

    public double getX(){
        return currentPosition.getX();
    }

    public double getY(){
        return currentPosition.getY();
    }

    public void setX(double x){
        currentPosition.setX(x);
    }

    public void setY(double y){
        currentPosition.setY(y);
    }

    public double getVelocityX(){
        return velocity.getX();
    }

    public double getVelocityY(){
        return velocity.getY();
    }

    public void setVelocityX(double x){
        velocity.setX(x);
    }

    public void setVelocityY(double y){
        velocity.setY(y);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    public int getAngle() {
        return angle;
    }

    public double getHeightCoef() {
        return heightCoef;
    }

    public void setHeightCoef(double heightCoef) {
        this.heightCoef = heightCoef;
    }

    public double getWidthCoef() {
        return widthCoef;
    }

    public void setWidthCoef(double widthCoef) {
        this.widthCoef = widthCoef;
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
    /*
    public Rectangle getRectangle() {
        return rect;
    }

    public void setRectangle(Rectangle r) {
        this.rect = r;
    }

     */

}
