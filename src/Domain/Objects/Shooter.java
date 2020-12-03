package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.ArrayList;
import java.util.HashMap;

public class Shooter extends GameObject {
    private HashMap<Subtype, Integer> numOfAtoms = new HashMap<Subtype, Integer>();
    private HashMap<Subtype, Integer> numOfPowerups = new HashMap<Subtype,Integer>();
    @Override
    public void collision(GameObject collider) {

    }
    public HashMap<Subtype, Integer> getNumOfAtoms(){
        return numOfAtoms;
    }
    public void setNumOfAtoms(HashMap<Subtype, Integer> updated){
        numOfAtoms = updated;
    }
}
