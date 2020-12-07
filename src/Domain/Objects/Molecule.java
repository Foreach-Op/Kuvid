package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.HashMap;

public class Molecule extends GameObject{
    public Molecule(Subtype type) {
        super();
    }


 /*   public void collision(GameObject obj){
        if(obj.type=="Atom"){
            if(this.equals(obj)){
                this.getDestroy();
                obj.getDestroy();
            } else{
                obj.getDestroy();
            }
        } else if(obj.type=="Blocker"){
            this.getDestroy();
        }
    }

    @Override
    public boolean equals(Object obj) {
        GameObject gameObj=(GameObject) obj;
        return this.subType.equals(gameObj.subType);
    }


    @Override
    public HashMap<Integer, HashMap<Subtype, Integer>> getCollected() {
        HashMap<Integer, HashMap<Subtype, Integer>> mapToReturn = new HashMap<Integer, HashMap<Subtype, Integer>>();
        HashMap<Subtype, Integer> map = new HashMap<Subtype, Integer>();
        map.put(this.subType, this.subType.getNumOfAtoms());
        mapToReturn.put(0, map);
        return mapToReturn;
    }*/
}
