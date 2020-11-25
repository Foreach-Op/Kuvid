package Domain.Listeners;

import Domain.Objects.GameObject;
import Domain.Objects.Position;

public interface ObjectListener {
    void addOnGameScreen();
    void onLocationChange(Position position);
    void onDestroy();
    void initialize(GameObject fallable);
}
