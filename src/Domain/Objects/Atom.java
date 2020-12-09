package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;





public class Atom extends GameObject implements Fireable {

    /*public Atom(Subtype type) {
        super();
    }*/
    private MovementofObject movement;

    public Atom(String subType, Position position){
        super(FinalValues.ATOM,subType,position);
    }

    @Override
    public void beFired(int angle) {
        this.movement = new MovementofObject((int) (-RunningMode.L/Math.tan(angle)), (int) RunningMode.L, 0 );
    }

}
