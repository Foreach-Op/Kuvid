package Domain.Factories;

import Domain.Objects.*;

public class FireableFactory {
    private static FireableFactory fireableFactory;

    private FireableFactory(){}

    public static FireableFactory getInstance(){
        if(fireableFactory ==null){
            fireableFactory =new FireableFactory();
        }
        return fireableFactory;
    }

    public Fireable getFireableObject(String object, String type){
        Fireable fireable=null;
        switch (object){
            case "Atom":
                fireable=new Atom(type);
                break;
            case "Powerup":
                fireable=new Powerup(type);
                // /src/Images/type/subtype
                break;
        }
        return fireable;
    }
}
