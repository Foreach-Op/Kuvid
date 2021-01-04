package UI;

import java.util.HashMap;

public interface UIListener {

    void onHomeScreen();
    void onConfigureScreen();
    void onStart(HashMap<String, String> configurationInfo);
    void onGameStart();
    void onGameOver();
    void onPause();
    void onResume();
    void onOptions();
    void onCredits();
    void onLoadScreen();
    void onSave();

    boolean isGameRunning();
}
