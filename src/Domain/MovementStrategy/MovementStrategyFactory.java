package Domain.MovementStrategy;


import Domain.Objects.GameObject;

public class MovementStrategyFactory {
    private static MovementStrategyFactory movementStrategyFactory;

    private MovementStrategyFactory(){}

    public static MovementStrategyFactory getInstance(){
        if(movementStrategyFactory==null){
            movementStrategyFactory=new MovementStrategyFactory();
        }
        return movementStrategyFactory;
    }

    public MovementStrategy getStrategy(GameObject obj){
        MovementStrategy movementStrategy;

        switch (obj.getType()){
            case "Atom":
                movementStrategy=new AtomMovement();
                break;
            case "Blocker":
                movementStrategy=new BlockerMovement();
                break;
            case "Molecule":
                movementStrategy=new MoleculeMovement();
                break;
            case "Powerup":
                movementStrategy=new PowerupMovement();
                break;
            default:
                //How to handle Shooter...
                throw new IllegalStateException("Unexpected value: " + obj.getType());
        }
        return  movementStrategy;
    }
}
