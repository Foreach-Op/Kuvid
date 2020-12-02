package Domain.Listeners;

import Domain.Objects.GameObject;
import Domain.Objects.Position;



public interface ObjectListener {

    void onCreate(GameObject obj);
    void addOnGameScreen();
    void onLocationChange();
    void onDestroy();
}
