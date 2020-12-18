package Domain.Collision;

import Domain.Objects.GameObject;
import Domain.Player.Player;
import Domain.Statistics.GameConfiguration;
import Domain.Utils.FinalValues;

import java.util.HashMap;

public class AtomMoleculeCollision implements CollisionStrategy{

    @Override
    public void doCollision(GameObject object1, GameObject object2) {
        if(object1.getSubType().equals(object2.getSubType())){
            System.out.println("collision");
            GameConfiguration configuration=GameConfiguration.getInstance();
            HashMap<String,HashMap<String,Integer>> ammo=configuration.getData().getAmmunition();
            HashMap<String,Integer> map=ammo.get(FinalValues.ATOM);
            map.replace(object1.getSubType(),map.get(object1.getSubType())+1);
            //Player.getInstance().increaseScore(1,);
            configuration.setAmmunition(ammo);
            object1.destroy();
            Player player= GameConfiguration.getInstance().getData().getPlayer();
            player.increaseScore(1);
        }
        object2.destroy();
    }
}
