package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;


public abstract class Atom extends GameObject implements Fireable {
    private double stability;

    private int num_of_protons;

    private int num_of_neutrons;


    public Atom(String subType, Position position, int angle) {
        super(FinalValues.ATOM, subType, position,angle,false);
        setVelocityY(-getVelocityY()*getL()/50);
        setVelocityX(getVelocityX()*getL()/50);
        setHeight((int) (getL()/5));
        setWidth((int) (getL()/5));
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));

    }

    public double getStability() {
        return stability;
    }

    public void setStability(double stability) {
        this.stability = stability;
    }

    public int getNum_of_protons() {
        return num_of_protons;
    }

    public void setNum_of_protons(int num_of_protons) {
        this.num_of_protons = num_of_protons;
    }

    public int getNum_of_neutrons() {
        return num_of_neutrons;
    }

    public void setNum_of_neutrons(int num_of_neutrons) {
        this.num_of_neutrons = num_of_neutrons;
    }
}
