package Domain.Objects;

import java.util.HashMap;

public class Shooter extends GameObject {

    private HashMap<String, HashMap<String, Integer>>  numOfBullets = new HashMap<String, HashMap<String, Integer>>();
    private static Shooter instance = null;
    private Shooter(){

    }
    public static Shooter getInstance(){
        if (instance == null) instance = new Shooter();
        return instance;
    }
    public void collision(GameObject collider) {

    }
    public void initializeBullets(HashMap<String, HashMap<String, Integer>> initial){
        numOfBullets = initial;
    }


    public HashMap<String, HashMap<String, Integer>> getNumOfBullets() {
        return numOfBullets;
    }
    public HashMap<String, Integer> getNumOfAtoms(){
        return numOfBullets.get("Molecule");
    }
    public void setNumOfAtoms(HashMap<String, Integer> set){
        numOfBullets.replace("Molecule", set);
    }


    public void collect(Collectable c){
        String type = c.getCollected()[0];
        String subtype = c.getCollected()[1];
        System.out.println(type);
        numOfBullets.get(type).replace(subtype, numOfBullets.get(type).get(subtype)+1);
    }

}
