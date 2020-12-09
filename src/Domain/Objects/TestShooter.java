package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

import java.util.HashMap;

public class TestShooter {
    public static void main(String[] args) {
        Gamma_Molecule molecule = new Gamma_Molecule(new Position(0,0));
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());
        molecule.getRectangle().applyMovement(molecule.getMovement());
        System.out.println(molecule.getPosition().getX() + " " + molecule.getPosition().getY());


    }
}
