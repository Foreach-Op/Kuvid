package Domain.CollisionStrategy;


import Domain.Objects.GameObject;

public class CollisionStrategyFactory {
    private static CollisionStrategyFactory collisionStrategyFactory;

    private CollisionStrategyFactory(){}

    public static CollisionStrategyFactory getInstance(){
        if(collisionStrategyFactory==null){
            collisionStrategyFactory=new CollisionStrategyFactory();
        }
        return collisionStrategyFactory;
    }

    public CollisionStrategy getStrategy(GameObject obj1,GameObject obj2){
        CollisionStrategy collisionStrategy=null;
        switch (obj1.getType()){
            case "Atom":
                collisionStrategy=new AtomCollision(obj1);
        }

        return collisionStrategy;
    }
}
