package Domain.Listeners;

import Domain.Objects.GameObject;
import Domain.Objects.Position;

public interface ObjectListener {
    void addOnGameScreen();
    void changeLocation(Position position);

    void initialize(GameObject fallable);
}
