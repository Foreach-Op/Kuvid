package Domain.Listeners;

import Domain.Objects.GameObject;
import Domain.Objects.Position;

import java.util.List;


public interface ObjectListener {

    void onCreate(GameObject obj);
    void addOnGameScreen();
    void onLocationChange();
    void onDestroy(GameObject obj1, GameObject obj2);
}
