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
    ArrayList<Position> cornerList;
    //This class is created for simulating the window of GameObjects.
    //will be updated, some problems occurs because of the double-int casting
    public Rectangle(Position p, double width, double height, int angle){
        this.locationX = (int) p.getX();
        this.locationY = (int) p.getY();
        this.length = height;
        this.width = width;
        this.angle = angle;
        cornerList = new ArrayList<Position>();
        cornerList.add(p);
        cornerList.add(new Position(locationX + width, locationY));
        cornerList.add(new Position(locationX, locationY + length));
        cornerList.add(new Position(locationX+width, locationY + length));

    }

    public ArrayList<Position> getCornerList() {
        return cornerList;
    }

    public boolean intersects(Rectangle second){

      for (Position p: cornerList){
          if(second.isIn(p)) return true;
        }

        for (Position p: second.getCornerList()){
            if(this.isIn(p)) return true;
        }

        return false;
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

    public boolean isIn(Position p){
        return p.getX()>= this.locationX && p.getX()<= this.locationX+width && p.getY()>=this.locationY && p.getY()<=this.locationY+length;
    }
}