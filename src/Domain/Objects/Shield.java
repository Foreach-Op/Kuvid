package Domain.Objects;

import Domain.Utils.FinalValues;

public class Shield extends GameObject{

    public Shield(String subType){
        super(FinalValues.SHIELD,subType);
    }
    public void improve_efficiency(Atom atom){}
}
