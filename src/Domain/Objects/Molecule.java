package Domain.Objects;


import Domain.Useful.FinalValues;

public class Molecule extends GameObject{

    /*public Molecule(Subtype type) {
        super();
    }*/

    public Molecule(String subType){
        super(FinalValues.MOLECULE,subType);
    }


/*
    @Override
    public HashMap<Integer, HashMap<Subtype, Integer>> getCollected() {
        HashMap<Integer, HashMap<Subtype, Integer>> mapToReturn = new HashMap<Integer, HashMap<Subtype, Integer>>();
        HashMap<Subtype, Integer> map = new HashMap<Subtype, Integer>();
        map.put(this.subType, this.subType.getNumOfAtoms());
        mapToReturn.put(0, map);
        return mapToReturn;
    }*/
}
