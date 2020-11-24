package Domain.Singletons;

import Domain.Objects.Fallable;
import Domain.Objects.Fireable;
import Domain.Objects.GameObject;
import Domain.Objects.Position;
import Domain.Useful.ConfigureData;
import Domain.Useful.Difficulty;
import Domain.Useful.Health;
import Domain.Useful.Score;

import java.util.ArrayList;
import java.util.HashMap;

public class GameConfiguration {
    private static GameConfiguration gameConfiguration;
    private ConfigureData data;

    private GameConfiguration(){}

    public static GameConfiguration getInstance(){
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    public ConfigureData getData() {
        return this.data;
    }

    public void setData(ConfigureData data) {
        this.data = data;
    }

    public void setData(HashMap<GameObject, Position> frameHash,
                        HashMap<String,HashMap<String,Integer>> remainingObjects,
                        Health health, Score score, int remainingTime,
                        Difficulty difficulty, HashMap<Fireable, Integer> ammunition,
                        Fireable objectInTheTrigger) {
        this.data=new ConfigureData(frameHash, remainingObjects, health, score, remainingTime, difficulty, ammunition, objectInTheTrigger);
    }


}
