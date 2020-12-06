package Domain.ObjectCreator;

import Domain.Objects.GameObject;

public class ObjectFactory {

    private static ObjectFactory objectFactory;

    private ObjectFactory(){}

    public static ObjectFactory getInstance(){
        if(objectFactory ==null){
            objectFactory =new ObjectFactory();
        }
        return objectFactory;
    }

    public static GameObject createObject(String type, String subtype){
        return null;
    }

    /* public HashMap<GameObject,ObjectListener> createFallableObject(String object,String subtype){
        Fallable fallable=null;
        ObjectListener objPanel=null;
        HashMap<GameObject,ObjectListener> map=new HashMap<>();
        switch (object){
            case "Molecule":
                fallable=new Molecule(subtype);
                objPanel=new ObjectPanel("Molecule",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Blocker":
                fallable=new Blocker(subtype);
                objPanel=new ObjectPanel("Blocker",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Powerup":
                fallable=new Powerup(subtype);
                objPanel=new ObjectPanel("Powerup",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
        }
        map.put((GameObject) fallable,objPanel);
        return map;
    }*/

    /* public HashMap<GameObject, ObjectListener> createFireableObject(String object, Subtype type){
        /*Fireable fireable=null;
        ObjectListener objPanel=null;
        HashMap<GameObject,ObjectListener> map=new HashMap<>();
        switch (object){
            case "Atom":
                fireable=new Atom(type);
                objPanel=new ObjectPanel("Atom",new Position());
                objPanel.initialize((GameObject) fireable);
                break;
            case "Powerup":
                fireable=new Powerup(type);
                objPanel=new ObjectPanel("Powerup",type,new Position());
                objPanel.initialize((GameObject) fireable);
                break;
        }
        map.put((GameObject) fireable,objPanel);
        return map;
    }*/



    /*public HashMap<GameObject, ObjectListener> createObject(String object){
        HashMap<GameObject, ObjectListener> ObjectMap;
        ObjectMap=createObject(object,"","");
        return ObjectMap;
    }


    public HashMap<GameObject, ObjectListener> createObject(String object, String type){
        HashMap<GameObject, ObjectListener> ObjectMap;
        if(object.equals("Atom")){
            ObjectMap=createObject(object,type,"Fireable");
        } else {
            ObjectMap=createObject(object,type,"Fallable");
        }

        return ObjectMap;

    }*/


    /*public HashMap<GameObject, ObjectListener> createObject(String object, String type, String property){
        HashMap<GameObject, ObjectListener> ObjectMap;
        switch (object){
            case "Powerup":
                if(property.equals("Fallable")){
                    ObjectMap = FallableFactory.getInstance().createFallableObject(object,type);
                } else {
                    ObjectMap = FireableFactory.getInstance().createFireableObject(object,type);
                }
                break;
            case "Atom":
                ObjectMap = FireableFactory.getInstance().createFireableObject(object,type);
                break;
            default:
                ObjectMap = FallableFactory.getInstance().createFallableObject(object,type);
        }
        return ObjectMap;*/
    }





