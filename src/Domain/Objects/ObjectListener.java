package Domain.Objects;

import Domain.Objects.GameObject;
import Domain.Objects.Position;

import java.util.List;


public interface ObjectListener {

    void onCreate(GameObject obj);
    void onLocationChange();
    void onDestroy(GameObject obj1, GameObject obj2);
}
