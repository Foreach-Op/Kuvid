package Domain.Modes;

import Domain.Functionalities.Load;
import Domain.Statistics.GameConfiguration;
import Domain.Player.Player;
import Domain.Statistics.GameData;
import Domain.Useful.*;

import java.util.HashMap;

public class BuildingMode {

    public void startNewGame(HashMap<String, String> configMap) {
        GameData gameData = hashToGameData(configMap);
        GameConfiguration.getInstance().setData(gameData);
        //RunningMode runningMode = new RunningMode();
    }

    public void loadTheGame(String fileName) {
        Load load = new Load(fileName);
        GameData gameData = load.LoadTheGame();
        GameConfiguration.getInstance().setData(gameData);
        Player.getInstance().setHealth(gameData.getHealth());
        Player.getInstance().setScore(gameData.getScore());
        //Time will be set

        //RunningMode runningMode = new RunningMode(gameData);
    }

    public GameData hashToGameData(HashMap<String, String> configHash) {
        GameData gameData = new GameData();

        gameData.setGameScreenWidth(Integer.parseInt(configHash.get("width")));
        gameData.setGameScreenHeight(Integer.parseInt(configHash.get("height")));
        System.out.println(gameData.getGameScreenHeight());

        boolean isLoaded = false;
        gameData.setLoaded(isLoaded);

        //----Ammunition
        HashMap<String, HashMap<String, Integer>> ammunition = new HashMap<>();

        int atomAmount = Integer.parseInt(configHash.get(FinalValues.ATOM));
        HashMap<String, Integer> initialAtomAmountHash = new HashMap<>();
        initialAtomAmountHash.put(FinalValues.ALPHA, atomAmount);
        initialAtomAmountHash.put(FinalValues.BETA, atomAmount);
        initialAtomAmountHash.put(FinalValues.GAMMA, atomAmount);
        initialAtomAmountHash.put(FinalValues.SIGMA, atomAmount);

        HashMap<String, Integer> initialPowerupAmountHash = new HashMap<>();
        initialPowerupAmountHash.put(FinalValues.ALPHA, 0);
        initialPowerupAmountHash.put(FinalValues.BETA, 0);
        initialPowerupAmountHash.put(FinalValues.GAMMA, 0);
        initialPowerupAmountHash.put(FinalValues.SIGMA, 0);

        ammunition.put(FinalValues.ATOM, initialAtomAmountHash);
        ammunition.put(FinalValues.POWERUP, initialPowerupAmountHash);
        gameData.setAmmunition(ammunition);

        //----Remaining Objects (Falling)
        HashMap<String, HashMap<String, Integer>> remainingObjects = new HashMap<>();

        int moleculeAmount = Integer.parseInt(configHash.get(FinalValues.MOLECULE));
        HashMap<String, Integer> moleculeAmountHash = new HashMap<>();
        moleculeAmountHash.put(FinalValues.ALPHA, moleculeAmount);
        moleculeAmountHash.put(FinalValues.BETA, moleculeAmount);
        moleculeAmountHash.put(FinalValues.GAMMA, moleculeAmount);
        moleculeAmountHash.put(FinalValues.SIGMA, moleculeAmount);

        int blockerAmount = Integer.parseInt(configHash.get(FinalValues.BLOCKER));
        HashMap<String, Integer> blockerAmountHash = new HashMap<>();
        blockerAmountHash.put(FinalValues.ALPHA, blockerAmount);
        blockerAmountHash.put(FinalValues.BETA, blockerAmount);
        blockerAmountHash.put(FinalValues.GAMMA, blockerAmount);
        blockerAmountHash.put(FinalValues.SIGMA, blockerAmount);

        int powerupAmount = Integer.parseInt(configHash.get(FinalValues.POWERUP));
        HashMap<String, Integer> powerupAmountHash = new HashMap<>();
        powerupAmountHash.put(FinalValues.ALPHA, powerupAmount);
        powerupAmountHash.put(FinalValues.BETA, powerupAmount);
        powerupAmountHash.put(FinalValues.GAMMA, powerupAmount);
        powerupAmountHash.put(FinalValues.SIGMA, powerupAmount);

        remainingObjects.put(FinalValues.MOLECULE, moleculeAmountHash);
        remainingObjects.put(FinalValues.BLOCKER, blockerAmountHash);
        remainingObjects.put(FinalValues.POWERUP, powerupAmountHash);
        gameData.setRemainingObjects(remainingObjects);

        //----Difficulty
        String difficultyStr = configHash.get("difficulty");
        Difficulty difficulty;
        if (difficultyStr.equals(Difficulty.HARD.toString())) {
            difficulty = Difficulty.HARD;
        } else if (difficultyStr.equals(Difficulty.NORMAL.toString())) {
            difficulty = Difficulty.NORMAL;
        } else {
            difficulty = Difficulty.EASY;
        }
        gameData.setDifficulty(difficulty);

        //---Length
        int length = Integer.parseInt(configHash.get("length"));
        gameData.setL(length);

        //---Type
        String alphaBetaType = configHash.get("structure");
        gameData.setAlphaBetaType(alphaBetaType);

        //---Movement
        MovementType alphaBetaMovementType;
        String movementType = configHash.get("fallingType");
        if (movementType.equals(MovementType.SPINNING.toString())) {
            alphaBetaMovementType = MovementType.SPINNING;
        } else {
            alphaBetaMovementType = MovementType.STATIONARY;
        }
        gameData.setAlphaBetaMovementType(alphaBetaMovementType);

        return gameData;
    }
}
