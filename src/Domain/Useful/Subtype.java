package Domain.Useful;

public enum Subtype {
    ALPHA("alpha",3),
    BETA("beta",4),
    GAMMA("gamma",5),
    SIGMA("sigma",6);
    //This class was created for subtypes. toString method can be used to find the path of gameObjects' icon.
    private String subtypeString;
    private int numOfAtoms;
    Subtype(String subtypeString, int numOfAtoms) {
        this.subtypeString = subtypeString;
        this.numOfAtoms = numOfAtoms;
    }

    @Override
    public String toString() {
        return subtypeString;
    }

    public int getNumOfAtoms() {
        return numOfAtoms;
    }
}
