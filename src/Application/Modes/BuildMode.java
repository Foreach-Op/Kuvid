package Application.Modes;

import Domain.Singletons.GameConfiguration;
import Domain.Useful.GameData;
import Domain.Useful.Difficulty;
import Domain.Useful.Load;
import Domain.Useful.MovementType;

import java.util.HashMap;

public class BuildMode {

    public void startNewGame(HashMap<String,String> configMap){
        GameData gameData =hashToConfigData(configMap);
        GameConfiguration.getInstance().setData(gameData);
    }

    public void loadTheGame(String fileName){
        Load load=new Load(fileName);
        GameData gameData =load.LoadTheGame();
        GameConfiguration.getInstance().setData(gameData);
    }

    public GameData hashToConfigData(HashMap<String,String> configMap){
        GameData gameData =new GameData();

        boolean isLoaded = false;

        HashMap<String, HashMap<String, Integer>> ammunition=new HashMap<>();
        int atomAmount=Integer.parseInt(configMap.get("atom"));


        HashMap<String, HashMap<String, Integer>> remainingObjects=new HashMap<>();
        int moleculeAmount=Integer.parseInt(configMap.get("molecule"));
        int blockerAmount=Integer.parseInt(configMap.get("blocker"));
        int powerupAmount=Integer.parseInt(configMap.get("powerup"));


        //----Difficulty
        String difficultyStr=configMap.get("difficulty");
        Difficulty difficulty;
        if(difficultyStr.equals("Hard")){
            difficulty=Difficulty.HARD;
        }else if(difficultyStr.equals("Normal")){
            difficulty=Difficulty.NORMAL;
        }else {
            difficulty=Difficulty.EASY;
        }

        //---L
        int L=Integer.getInteger(configMap.get("length"));

        //---Type
        String alphaBetaType=configMap.get("structure");

        //---Movement
        MovementType alphaBetaMovementType;
        String movementType=configMap.get("type");
        if(movementType.equals("Spinning")){
            alphaBetaMovementType=MovementType.SPINNING;
        }else {
            alphaBetaMovementType=MovementType.STATIONARY;
        }





        return gameData;

    }
}
