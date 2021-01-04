package UI;

public class Test {
    public static void main(String[] args) {
        UIController uiController = UIController.GetInstance();
        uiController.openHomeScreen();

        Audio backgroundMusic = new Audio("background");
        backgroundMusic.Start(true);
        backgroundMusic.SetVolume(1);
    }
}
