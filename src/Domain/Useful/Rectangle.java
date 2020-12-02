package Domain.Useful;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    int locationX;
    int locationY;
    int length;
    int width;
    double angle;
    ArrayList<Point> pointList;
    //This class is created for simulating the window of GameObjects.
    //will be updated, some problems occurs because of the double-int casting
    public Rectangle(int locationX, int locationY, int width, int length, double angle){
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.angle = angle;
        initializePointList();
    }
    public void initializePointList(){
        pointList = new ArrayList<Point>();
        for(int x = 0; x<width ;x++){
            for(int y = 0; y<length; y++){
                int rotatedX = (int) (x*Math.cos(angle) - y*Math.sin(angle)) ;
                int rotatedY = (int) (x*Math.sin(angle) + y* Math.cos(angle)) ;
                pointList.add(new Point(rotatedX + locationX, rotatedY+locationY));
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

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

}