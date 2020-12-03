package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.ArrayList;
import java.util.HashMap;

public class Shooter extends GameObject {
    private HashMap<Subtype, Integer> numOfAtoms = new HashMap<Subtype, Integer>();
    private HashMap<Subtype, Integer> numOfPowerups = new HashMap<Subtype,Integer>();

    public Shooter(){
        numOfAtoms.put(Subtype.ALPHA,0);
        numOfAtoms.put(Subtype.BETA,0);
        numOfAtoms.put(Subtype.GAMMA,0);
        numOfAtoms.put(Subtype.SIGMA,0);
        numOfPowerups.put(Subtype.ALPHA,0);
        numOfPowerups.put(Subtype.BETA,0);
        numOfPowerups.put(Subtype.GAMMA,0);
        numOfPowerups.put(Subtype.SIGMA,0);


    }
    public void collision(GameObject collider) {

    }
    public HashMap<Subtype, Integer> getNumOfAtoms(){
        return numOfAtoms;
    }
    public void setNumOfAtoms(HashMap<Subtype, Integer> updated){
        numOfAtoms = updated;
    }

    public HashMap<Subtype, Integer> getNumOfPowerups() {
        return numOfPowerups;
    }

    public void addAtoms(HashMap<Subtype, Integer> add){
        if(add!=null){
            for(Subtype s: add.keySet()){
                numOfAtoms.replace(s, numOfAtoms.get(s)+add.get(s));
            }
        }

    }
    public void addPowerups(HashMap<Subtype, Integer> add){
        if(add!=null){
            for(Subtype s: add.keySet()){
                numOfPowerups.replace(s, numOfPowerups.get(s)+add.get(s));
            }
        }
    }
    public void collect(Collectable c){
        HashMap<Integer, HashMap<Subtype, Integer>> map = c.getCollected();
        addAtoms(map.get(0));
        addPowerups(map.get(1));
    }

}
