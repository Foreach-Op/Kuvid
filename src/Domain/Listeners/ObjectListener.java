package Domain.Listeners;

import Domain.Objects.GameObject;
import Domain.Objects.Position;



public interface ObjectListener {
    //can we have a createMethod? GameScreen (or main GUI screen) will implement the createPanelListener.
    //for every new object that will be added to gameScreen, we will call
    //onCreate(GameObject obj).
    // Then, the game screen will create panel of the object and add it to HashMap<GameObject, JPanel>.
    void addOnGameScreen(); // we will add also the GameObject as an input to these methods. Then gameScreen will find
    //corresponding JPanel of each object and operate it.
    void onLocationChange(Position position);
    void onDestroy(); // in onDestroy we delete the object from HashMap for space efficiency.
    void initialize(GameObject fallable);
}
