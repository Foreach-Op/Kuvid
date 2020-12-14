package Domain.Collision;


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
           
            case "Blocker":
                if(obj2.getType().equals("Atom") || obj2.getType().equals("Molecule")){
                    collisionStrategy=new BlockerAtomMoleculeCollision();
                }
                break;
            case "Powerup":
                if(obj2.getType().equals("Blocker")){
                    collisionStrategy=new PowerupBlockerCollision();
                }
                break;
            case "Shooter":
                if(obj2.getType().equals("Blocker")){
                    collisionStrategy=new ShooterBlockerCollision();
                } else if (obj2.getType().equals("Powerup")){
                    collisionStrategy=new ShooterPowerupCollision();
                }
                break;
            case "Molecule":
                if(obj2.getType().equals("Atom")){
                    collisionStrategy=new AtomMoleculeCollision();
                }
                break;
            default:
                collisionStrategy=null;
        }

        return collisionStrategy;
    }
}
