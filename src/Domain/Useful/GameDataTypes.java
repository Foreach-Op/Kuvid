package Domain.Useful;

public enum GameDataTypes {
    ATOM("atom"),
    MOLECULE("molecule"),
    REACTION_BLOCKER("blocker"),
    POWER_UP("powerup"),
    DIFFICULTY("difficulty"),
    LENGTH("length"),
    MOLECULE_STRUCTURE("structure"),
    MOLECULE_MOVEMENT_TYPE("movementType");

    private String info;
    GameDataTypes(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }
}
