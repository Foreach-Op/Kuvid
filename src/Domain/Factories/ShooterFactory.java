package Domain.Factories;

import Domain.Listeners.ObjectListener;
import Domain.Objects.*;
import UI.ObjectPanel;

import java.util.HashMap;

public class ShooterFactory {
    private static ShooterFactory shooterFactory;

    private ShooterFactory(){}

    public static ShooterFactory getInstance(){
        if(shooterFactory ==null){
            shooterFactory =new ShooterFactory();
        }
        return shooterFactory;
    }



    public HashMap<GameObject, ObjectListener> createShooterObject(String object){

        HashMap<GameObject,ObjectListener> map=new HashMap<>();
        GameObject shooter = new Shooter();
        ObjectListener objPanel=new ObjectPanel("Shooter","Shooter",new Position());
        objPanel.initialize((GameObject) shooter);
        map.put((GameObject) shooter,objPanel);
        return map;
    }

}
