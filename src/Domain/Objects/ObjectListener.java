package Domain.Objects;

public interface ObjectListener {

    void onCreate(GameObject obj);
    void onLocationChange();
    void onDestroy(GameObject obj1);
    void onShooterTriggerBulletChange();
    void onShooterPositionChange();
}
