package UI.Audio;

public interface AudioListener {
    void onStart();
    void onGameStart();
    void onExplosion();
    void onFire();
    void onGameOver();
    void onBlock();
}
