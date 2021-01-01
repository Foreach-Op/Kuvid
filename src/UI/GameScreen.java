package UI;

import Domain.DomainControl.GameController;
import Domain.Objects.ObjectListener;
import Domain.DomainControl.RunningMode;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Utils.GameActionHandler;
import Domain.Utils.HotKeys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScreen extends JFrame implements ObjectListener {

    private StatisticsWindow statisticsWindow;
    private JFrame gameScreen;
    private GameController gameController;
    private GamePanel gamePanel;

    public GameScreen() {
        CreateUIElements();
    }

    public void InitializeGameScreen(GameController gameController){
        this.gameController = gameController;
        statisticsWindow.SetData(GameConfiguration.getInstance().getData());
        statisticsWindow.SetGameController(gameController);
        GameActionListener();
    }

    private void CreateUIElements() {
        gameScreen = new JFrame("KUVID GAME");
        gameScreen.setSize(ScreenInfo.WINDOW_WIDTH, ScreenInfo.WINDOW_HEIGHT);
        gameScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen.setResizable(false);

        statisticsWindow = new StatisticsWindow(ScreenInfo.STATISTICS_WINDOW_WIDTH, ScreenInfo.GAME_SCREEN_HEIGHT);
        GameConfiguration.getInstance().setStaticWindowListener(statisticsWindow);
        gameScreen.add(statisticsWindow.panelMain, BorderLayout.EAST);
        statisticsWindow.panelMain.setPreferredSize(new Dimension(ScreenInfo.STATISTICS_WINDOW_WIDTH, ScreenInfo.GAME_SCREEN_HEIGHT));

        gamePanel = new GamePanel(ScreenInfo.GAME_SCREEN_WIDTH,ScreenInfo.GAME_SCREEN_HEIGHT);
        gameScreen.add(gamePanel);

        pack();
        gameScreen.setVisible(true);
    }

    private void GameActionListener() {
        final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

        JPanel contentPane = (JPanel) gameScreen.getContentPane();

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.MOVE_LEFT.getValue(), 0), "move left"); // TRUE'da action almadı
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.MOVE_RIGHT.getValue(),0), "move right");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ROTATE_LEFT.getValue(),0), "rotate left");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ROTATE_RIGHT.getValue(), 0), "rotate right");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.SHOOT.getValue(),0), "fire");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.PICK_ATOM.getValue(),0), "pick atom");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.BLEND.getValue(),0), "blend");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.PAUSE.getValue(),0), "pause");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE1.getValue(), KeyEvent.ALT_DOWN_MASK), "choose powerup 1");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE2.getValue(), KeyEvent.ALT_DOWN_MASK), "choose powerup 2");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE3.getValue(), KeyEvent.ALT_DOWN_MASK), "choose powerup 3");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE4.getValue(), KeyEvent.ALT_DOWN_MASK), "choose powerup 4");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE1.getValue(), KeyEvent.SHIFT_DOWN_MASK), "eta shield");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE2.getValue(), KeyEvent.SHIFT_DOWN_MASK), "lota shield");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE3.getValue(), KeyEvent.SHIFT_DOWN_MASK), "theta shield");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE4.getValue(), KeyEvent.SHIFT_DOWN_MASK), "zeta shield");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE1.getValue(), 0), "atom 1");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE2.getValue(), 0), "atom 2");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE3.getValue(), 0), "atom 3");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE4.getValue(), 0), "atom 4");

        contentPane.getActionMap().put("move right", new GameActionHandler("move right", gameController));
        contentPane.getActionMap().put("move left", new GameActionHandler("move left", gameController));
        contentPane.getActionMap().put("rotate left", new GameActionHandler("rotate left", gameController));
        contentPane.getActionMap().put("rotate right", new GameActionHandler("rotate right", gameController));
        contentPane.getActionMap().put("pick atom", new GameActionHandler("pick atom", gameController));
        contentPane.getActionMap().put("fire", new GameActionHandler("fire", gameController));
        contentPane.getActionMap().put("blend", new GameActionHandler("blend", gameController));
        contentPane.getActionMap().put("pause", new GameActionHandler("pause", gameController));

        contentPane.getActionMap().put("choose powerup 1", new GameActionHandler("choose powerup 1", gameController));
        contentPane.getActionMap().put("choose powerup 2", new GameActionHandler("choose powerup 2", gameController));
        contentPane.getActionMap().put("choose powerup 3", new GameActionHandler("choose powerup 3", gameController));
        contentPane.getActionMap().put("choose powerup 4", new GameActionHandler("choose powerup 4", gameController));

        contentPane.getActionMap().put("eta shield", new GameActionHandler("eta shield", gameController));
        contentPane.getActionMap().put("lota shield", new GameActionHandler("lota shield", gameController));
        contentPane.getActionMap().put("theta shield", new GameActionHandler("theta shield", gameController));
        contentPane.getActionMap().put("zeta shield", new GameActionHandler("zeta shield", gameController));

        contentPane.getActionMap().put("atom 1", new GameActionHandler("atom 1", gameController));
        contentPane.getActionMap().put("atom 2", new GameActionHandler("atom 2", gameController));
        contentPane.getActionMap().put("atom 3", new GameActionHandler("atom 3", gameController));
        contentPane.getActionMap().put("atom 4", new GameActionHandler("atom 4", gameController));
    }

    @Override
    public void onCreate(GameObject obj) {
        gamePanel.onCreate(obj);
    }

    @Override
    public void onLocationChange() {
        gamePanel.onLocationChange();
    }

    @Override
    public void onDestroy(GameObject obj1) {
        gamePanel.onDestroy(obj1);
    }

    @Override
    public void onShooterTriggerBulletChange() {
        gamePanel.onShooterTriggerBulletChange();
    }

    @Override
    public void onShooterPositionChange() {
        gamePanel.onShooterPositionChange();
    }

    public void initialize(RunningMode runningMode) {
        runningMode.setFrameListener(this);
    }
}
