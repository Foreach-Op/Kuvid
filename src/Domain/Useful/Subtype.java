package Domain.Useful;

public enum Subtype {
    ALPHA("alpha"),
    BETA("beta"),
    GAMMA("gamma"),
    SIGMA("sigma");
    //This class was created for subtypes. toString method can be used to find the path of gameObjects' icon.
    private String subtypeString;
    Subtype(String subtypeString) {
        this.subtypeString = subtypeString;
    }

    @Override
    public String toString() {
        return subtypeString;
    }
}
