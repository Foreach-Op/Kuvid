package Domain.Objects;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class TestShooter {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> atoms = new HashMap<String, Integer>();
        atoms.put(FinalValues.ALPHA, 15);
        atoms.put(FinalValues.BETA, 15);
        atoms.put(FinalValues.GAMMA, 15);
        atoms.put(FinalValues.SIGMA, 15);
        HashMap<String, Integer> atoms2 = new HashMap<String, Integer>();
        atoms2.put(FinalValues.ALPHA, 15);
        atoms2.put(FinalValues.BETA, 15);
        atoms2.put(FinalValues.GAMMA, 15);
        atoms2.put(FinalValues.SIGMA, 15);
        map.put(FinalValues.ATOM, atoms);
        map.put(FinalValues.POWERUP, atoms2);
        /*
        Shooter.getInstance().initializeBullets(map);
        Shooter.getInstance().changeBullet();
        System.out.println(Shooter.getInstance().getCurrentBullet().toString());
        Shooter.getInstance().fire();
        System.out.println(Shooter.getInstance().getNumOfBullets());
        System.out.println(Shooter.getInstance().getCurrentBullet().toString());
        Shooter.getInstance().fire();
        System.out.println(Shooter.getInstance().getNumOfBullets());
        System.out.println(Shooter.getInstance().getCurrentBullet().toString());
        Shooter.getInstance().changeBulletToPowerup(FinalValues.BETA);
        System.out.println(Shooter.getInstance().getCurrentBullet().toString());
        Shooter.getInstance().fire();
        System.out.println(Shooter.getInstance().getNumOfBullets());
        System.out.println(Shooter.getInstance().getCurrentBullet().toString());

         */

    }
}
