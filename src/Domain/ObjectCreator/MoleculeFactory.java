package Domain.ObjectCreator;

import Domain.Objects.*;

public class MoleculeFactory {
    private static MoleculeFactory moleculeFactory;

    private MoleculeFactory(){}

    public static MoleculeFactory getInstance(){
        if(moleculeFactory ==null){
            moleculeFactory =new MoleculeFactory();
        }
        return moleculeFactory;
    }


    public GameObject createMolecule(String subtype) {

        switch (subtype) {
            case "Alpha":
                return new Alpha_Molecule();

            case "Beta":
                return new Beta_Molecule();

            case "Gamma":
                return new Gamma_Molecule();

            default:
                return new Sigma_Molecule();

        }


    }
}
