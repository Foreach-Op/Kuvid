package Domain.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    private int locationX;
    private int locationY;
    private double length;
    private double width;
    private int angle;
    private ArrayList<Point> pointList;
    //This class is created for simulating the window of GameObjects.
    //will be updated, some problems occurs because of the double-int casting
    public Rectangle(Position p, double width, double height, int angle){
        this.locationX = (int) p.getX();
        this.locationY = (int) p.getY();
        this.length = height;
        this.width = width;
        this.angle = angle;
        setPointList(angle);
    }
    public void setPointList(double angle){
        pointList = new ArrayList<Point>();
        for(int x = -((int)width/2); x<width/2 ;x++){
            for(int y = -((int)length/2); y<length/2; y++){
                int rotatedX = (int) (x*Math.cos(angle) - y*Math.sin(angle)) ;
                int rotatedY = (int) (x*Math.sin(angle) + y* Math.cos(angle)) ;
                pointList.add(new Point(rotatedX + locationX +(int)width/2, rotatedY+locationY + (int) length/2));
            }
        }
    }
    public boolean intersects(Rectangle second){
        if (Collections.disjoint(second.pointList, this.pointList)) return false;
        return true;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Position getPosition(){
        return new Position(getLocationX(), getLocationY());
    }
}