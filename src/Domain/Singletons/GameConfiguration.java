package Domain.Singletons;

import Domain.Objects.Fireable;
import Domain.Objects.GameObject;
import Domain.Useful.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GameConfiguration {
    private static GameConfiguration gameConfiguration;
    private GameData data;

    private GameConfiguration(){}

    public static GameConfiguration getInstance(){
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    public GameData getData() {
        return this.data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public void setData(ArrayList<GameObject> frameObjects, Health health,
                        Score score, int remainingTime, Fireable objectInTheTrigger,
                        HashMap<String, HashMap<String, Integer>> powerUps, boolean isLoaded,
                        HashMap<String, HashMap<String, Integer>> ammunition,
                        HashMap<String, HashMap<String, Integer>> remainingObjects,
                        Difficulty difficulty, int l, String alphaBetaType,
                        MovementType alphaBetaMovementType) {
    this.data=new GameData(frameObjects, health, score, remainingTime, objectInTheTrigger, powerUps, isLoaded, ammunition, remainingObjects, difficulty, l, alphaBetaType, alphaBetaMovementType);
    }


}
