package Domain.Movement;


import Domain.Objects.GameObject;

public class MovementStrategyFactory {

    public static MovementStrategy getStrategy(GameObject obj){
        MovementStrategy movementStrategy=null;

        switch (obj.getType()){
            case "Atom":
                movementStrategy=new AtomMovement();
                break;
            case "Blocker":
                movementStrategy=new BlockerMovement();
                break;
            case "Molecule":
                switch (obj.getSubType()){
                    case "Alpha":
                        movementStrategy=new AlphaMoleculeMovement();
                        break;
                    case "Beta":
                        movementStrategy=new BetaMoleculeMovement();
                        break;
                    case "Gamma":
                        movementStrategy=new GammaMoleculeMovement();
                        break;
                    case "Sigma":
                        movementStrategy=new SigmaMoleculeMovement();
                        break;
                }
                break;
            case "Powerup":
                movementStrategy=new PowerupMovement();
                break;
            default:
                //How to handle Shooter...
                movementStrategy=new SigmaMoleculeMovement();
                //throw new IllegalStateException("Unexpected value: " + obj.getType());
        }
        return  movementStrategy;
    }
}
