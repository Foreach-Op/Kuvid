package UI;

public class Test {
    public static void main(String[] args) {
        UIController uiController = UIController.GetInstance();
        uiController.onHomeScreen();

        AudioController.GetInstance().onStart();
    }
}
