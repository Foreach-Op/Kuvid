package Domain.Useful;

public class Position {
    private int x;
    private int y;
    private int rotation=90;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(){}

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }



}
