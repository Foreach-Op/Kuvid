package Domain.Objects;

public interface ObjectListener {

    void onCreate(GameObject obj);
    void onLocationChange();
    void onDestroy(GameObject obj1, GameObject obj2);
    void onCreateShooter(GameObject shooter);
    void onShooterTriggerBulletChange();
    void onShooterPositionChange();
}
