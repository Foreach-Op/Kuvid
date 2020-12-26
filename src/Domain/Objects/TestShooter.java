package Domain.Objects;

import Domain.Utils.Position;

public class TestShooter {
    public static void main(String[] args) {

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


        Beta_Atom atom = new Beta_Atom(new Position(1, 2), 0);
        System.out.println(atom.getEfficiency());
        System.out.println(atom.getVelocity().getX() + " " + atom.getVelocity().getY());
        Theta_Shield shield = new Theta_Shield(atom);
        Zeta_Shield shield2 = new Zeta_Shield(shield);
        System.out.println(shield2.getEfficiency());
        System.out.println(shield2.getVelocity().getX() + " " + shield2.getVelocity().getY());


    }
}
