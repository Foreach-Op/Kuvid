package Domain.Objects;


import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Molecule extends GameObject implements Collectable{

    /*public Molecule(Subtype type) {
        super();
    }*/

    public Molecule(String subType, Position position){
        super(FinalValues.MOLECULE,subType,position);
    }




    public String[] getCollected() {
      String[] result = new String[2];
      result[0] = FinalValues.ATOM;
      result[1] = this.getSubType();
        return result;
    }
}
