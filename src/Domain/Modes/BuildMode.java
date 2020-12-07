package Domain.Modes;

import Domain.Singletons.GameConfiguration;
import Domain.Useful.*;

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
        int atomAmount=Integer.parseInt(configMap.get(GameDataTypes.ATOM.toString()));


        HashMap<String, HashMap<String, Integer>> remainingObjects=new HashMap<>();
        int moleculeAmount=Integer.parseInt(configMap.get(GameDataTypes.MOLECULE.toString()));
        int blockerAmount=Integer.parseInt(configMap.get(GameDataTypes.REACTION_BLOCKER.toString()));
        int powerupAmount=Integer.parseInt(configMap.get(GameDataTypes.POWER_UP.toString()));


        //----Difficulty
        String difficultyStr=configMap.get(GameDataTypes.DIFFICULTY.toString());
        Difficulty difficulty;
        if(difficultyStr.equals("Hard")){
            difficulty=Difficulty.HARD;
        }else if(difficultyStr.equals("Normal")){
            difficulty=Difficulty.NORMAL;
        }else {
            difficulty=Difficulty.EASY;
        }

        //---L
        int L=Integer.getInteger(configMap.get(GameDataTypes.LENGTH.toString()));

        //---Type
        String alphaBetaType=configMap.get(GameDataTypes.MOLECULE_STRUCTURE.toString());

        //---Movement
        MovementType alphaBetaMovementType;
        String movementType=configMap.get(GameDataTypes.MOLECULE_MOVEMENT_TYPE.toString());
        if(movementType.equals("Spinning")){
            alphaBetaMovementType=MovementType.SPINNING;
        }else {
            alphaBetaMovementType=MovementType.STATIONARY;
        }





        return gameData;

    }
}
