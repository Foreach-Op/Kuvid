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

        boolean isLoaded = false;
        gameData.setLoaded(isLoaded);

        //----Ammunition
        HashMap<String, HashMap<String, Integer>> ammunition = new HashMap<>();

        int atomAmount = Integer.parseInt(configHash.get(GameDataTypes.ATOM.toString()));
        HashMap<String, Integer> initialAtomAmountHash = new HashMap<>();
        initialAtomAmountHash.put(GameDataTypes.ATOM_ALPHA.toString(), atomAmount);
        initialAtomAmountHash.put(GameDataTypes.ATOM_BETA.toString(), atomAmount);
        initialAtomAmountHash.put(GameDataTypes.ATOM_GAMMA.toString(), atomAmount);
        initialAtomAmountHash.put(GameDataTypes.ATOM_SIGMA.toString(), atomAmount);

        HashMap<String, Integer> initialPowerupAmountHash = new HashMap<>();
        initialPowerupAmountHash.put(GameDataTypes.POWERUP_ALPHA.toString(), 0);
        initialPowerupAmountHash.put(GameDataTypes.POWERUP_BETA.toString(), 0);
        initialPowerupAmountHash.put(GameDataTypes.POWERUP_GAMMA.toString(), 0);
        initialPowerupAmountHash.put(GameDataTypes.POWERUP_SIGMA.toString(), 0);

        ammunition.put(GameDataTypes.ATOM.toString(), initialAtomAmountHash);
        ammunition.put(GameDataTypes.POWER_UP.toString(), initialPowerupAmountHash);
        gameData.setAmmunition(ammunition);

        //----Remaining Objects (Falling)
        HashMap<String, HashMap<String, Integer>> remainingObjects = new HashMap<>();

        int moleculeAmount = Integer.parseInt(configHash.get(GameDataTypes.MOLECULE.toString()));
        HashMap<String, Integer> moleculeAmountHash = new HashMap<>();
        moleculeAmountHash.put(GameDataTypes.MOLECULE_ALPHA.toString(), moleculeAmount);
        moleculeAmountHash.put(GameDataTypes.MOLECULE_BETA.toString(), moleculeAmount);
        moleculeAmountHash.put(GameDataTypes.MOLECULE_GAMMA.toString(), moleculeAmount);
        moleculeAmountHash.put(GameDataTypes.MOLECULE_SIGMA.toString(), moleculeAmount);

        int blockerAmount = Integer.parseInt(configHash.get(GameDataTypes.REACTION_BLOCKER.toString()));
        HashMap<String, Integer> blockerAmountHash = new HashMap<>();
        blockerAmountHash.put(GameDataTypes.BLOCKER_ALPHA.toString(), blockerAmount);
        blockerAmountHash.put(GameDataTypes.BLOCKER_BETA.toString(), blockerAmount);
        blockerAmountHash.put(GameDataTypes.BLOCKER_GAMMA.toString(), blockerAmount);
        blockerAmountHash.put(GameDataTypes.BLOCKER_SIGMA.toString(), blockerAmount);

        int powerupAmount = Integer.parseInt(configHash.get(GameDataTypes.POWER_UP.toString()));
        HashMap<String, Integer> powerupAmountHash = new HashMap<>();
        powerupAmountHash.put(GameDataTypes.POWERUP_ALPHA.toString(), powerupAmount);
        powerupAmountHash.put(GameDataTypes.POWERUP_BETA.toString(), powerupAmount);
        powerupAmountHash.put(GameDataTypes.POWERUP_GAMMA.toString(), powerupAmount);
        powerupAmountHash.put(GameDataTypes.POWERUP_SIGMA.toString(), powerupAmount);

        remainingObjects.put(GameDataTypes.MOLECULE.toString(), moleculeAmountHash);
        remainingObjects.put(GameDataTypes.REACTION_BLOCKER.toString(), blockerAmountHash);
        remainingObjects.put(GameDataTypes.POWER_UP.toString(), powerupAmountHash);
        gameData.setRemainingObjects(remainingObjects);

        //----Difficulty
        String difficultyStr = configHash.get(GameDataTypes.DIFFICULTY.toString());
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
        int length = Integer.parseInt(configHash.get(GameDataTypes.LENGTH.toString()));
        gameData.setL(length);

        //---Type
        String alphaBetaType = configHash.get(GameDataTypes.MOLECULE_STRUCTURE.toString());
        gameData.setAlphaBetaType(alphaBetaType);

        //---Movement
        MovementType alphaBetaMovementType;
        String movementType = configHash.get(GameDataTypes.MOLECULE_MOVEMENT_TYPE.toString());
        if (movementType.equals(MovementType.SPINNING.toString())) {
            alphaBetaMovementType = MovementType.SPINNING;
        } else {
            alphaBetaMovementType = MovementType.STATIONARY;
        }
        gameData.setAlphaBetaMovementType(alphaBetaMovementType);

        return gameData;
    }
}
