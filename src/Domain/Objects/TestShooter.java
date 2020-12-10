package Domain.Objects;

import Domain.MovementStrategy.Movement;
import Domain.MovementStrategy.MovementStrategy;
import Domain.MovementStrategy.MovementStrategyFactory;
import Domain.TimerBased.MovementHandler;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

import java.util.HashMap;

public class TestShooter {
    public static void main(String[] args) {
        Gamma_Molecule molecule = new Gamma_Molecule(new Position(0,0));
        /*
        MovementStrategy movementStrategy= MovementStrategyFactory.getInstance().getStrategy(molecule);
        Movement movement=new Movement(movementStrategy);
        //movement.executeMovement(molecule);
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        //movement.executeMovement(molecule);
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        //movement.executeMovement(molecule);
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        //movement.executeMovement(molecule);
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        //movement.executeMovement(molecule);
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        //movement.executeMovement(molecule);
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());

         */





    }
}
