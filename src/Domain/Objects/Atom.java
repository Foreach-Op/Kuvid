package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;





public class Atom extends GameObject {

    /*public Atom(Subtype type) {
        super();
    }*/
    private MovementofObject movement;

    public Atom(String subType, int angle){
        super(FinalValues.ATOM, subType, Shooter.getInstance().position());
        this.movement = new MovementofObject((int) (-RunningMode.L/Math.tan(angle)), (int) RunningMode.L, 0 );
    }

}
