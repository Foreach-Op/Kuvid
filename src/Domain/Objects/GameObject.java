package Domain.Objects;

//import Domain.Modes.RunningMode;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public abstract class GameObject {

    private boolean isAlive=true;
    private String type;
    private String subType;
    //private Rectangle rect;
    private Position currentPosition;
    private final int L = GameConfiguration.getInstance().getData().getL();
    private int height;
    private int width;
    private Position velocity;
    private int angle;
    private boolean isFallable;


    public GameObject() {
    }

    public GameObject(String type, String subType, Position position,int angle,boolean isFallable) {
        this.type = type;
        this.subType = subType;
        this.currentPosition=position;
        this.angle=angle;
        velocity =new Position(1,1);
        this.height=L;
        this.width=L;
        this.isFallable=isFallable;
        //this.rect=new Rectangle(position,widthCoef,heightCoef,angle);
    }

    public boolean isFallable() {
        return isFallable;
    }

    public int getL() {
        return L;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
