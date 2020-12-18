package Domain.Collision;


import Domain.Objects.GameObject;

public class CollisionStrategyFactory {


    public static CollisionStrategy getStrategy(GameObject obj1,GameObject obj2){
        CollisionStrategy collisionStrategy=null;
        switch (obj1.getType()){
           
            case "Blocker":
                if(obj2.getType().equals("Atom") || obj2.getType().equals("Molecule")){
                    collisionStrategy=new BlockerAtomMoleculeCollision();
                } else if(obj2.getType().equals("Powerup")){
                    collisionStrategy=new BlockerPoweupCollision();
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
