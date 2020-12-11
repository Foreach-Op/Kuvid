package UI;

import Domain.Modes.GameController;
import Domain.Objects.ObjectListener;
import Domain.Modes.RunningMode;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.GameActionHandler;
import Domain.Useful.HotKeys;
import Domain.Useful.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class GameScreen extends JFrame implements ObjectListener {

    private StatisticsWindow statisticsWindow;
    private JFrame gameScreen;
    private GameController gameController;
    private GamePanel gamePanel;

    private static final int STATISTICS_WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 5;
    public final int GAME_SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - STATISTICS_WINDOW_WIDTH;
    public static final int GAME_SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public GameScreen() {
        CreateUIElements();
    }

    public void InitializeGameScreen(GameController gameController){
        this.gameController = gameController;
        statisticsWindow.SetData(GameConfiguration.getInstance().getData());
        GameActionListener();
    }

    private void CreateUIElements() {
        //?
        gameScreen = new JFrame("KUVID GAME");
        gameScreen.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        gameScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen.setResizable(false);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("assets/kuvid_bc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(gameScreen.getWidth(), gameScreen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        gameScreen.add(new JLabel(imageIcon));

        statisticsWindow = new StatisticsWindow(STATISTICS_WINDOW_WIDTH, GAME_SCREEN_HEIGHT);
        GameConfiguration.getInstance().setStaticWindowListener(statisticsWindow);
        gameScreen.add(statisticsWindow.panelMain, BorderLayout.EAST);
        statisticsWindow.panelMain.setPreferredSize(new Dimension(STATISTICS_WINDOW_WIDTH, GAME_SCREEN_HEIGHT));


        gamePanel = new GamePanel();
        //gamePanel.setBackground(Color.BLACK);
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
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.RESUME.getValue(),0), "resume");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "save");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("L"), "load");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE1.getValue(), 0), "atom 1");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE2.getValue(), 0), "atom 2");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE3.getValue(), 0), "atom 3");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE4.getValue(), 0), "atom 4");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE1.getValue(), KeyEvent.ALT_MASK), "choose powerup 1");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE2.getValue(), KeyEvent.ALT_MASK), "choose powerup 2");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE3.getValue(), KeyEvent.ALT_MASK), "choose powerup 3");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke(HotKeys.ATOM_TYPE4.getValue(), KeyEvent.ALT_MASK), "choose powerup 4");


        contentPane.getActionMap().put("move right", new GameActionHandler("move right", gameController));
        contentPane.getActionMap().put("move left", new GameActionHandler("move left", gameController));
        contentPane.getActionMap().put("rotate left", new GameActionHandler("rotate left", gameController));
        contentPane.getActionMap().put("rotate right", new GameActionHandler("rotate right", gameController));
        contentPane.getActionMap().put("pick atom", new GameActionHandler("pick atom", gameController));
        contentPane.getActionMap().put("fire", new GameActionHandler("fire", gameController));
        contentPane.getActionMap().put("blend", new GameActionHandler("blend", gameController));
        contentPane.getActionMap().put("pause", new GameActionHandler("pause", gameController));
        contentPane.getActionMap().put("resume", new GameActionHandler("resume", gameController));
        contentPane.getActionMap().put("choose powerup 1", new GameActionHandler("choose powerup 1", gameController));
        contentPane.getActionMap().put("choose powerup 2", new GameActionHandler("choose powerup 2", gameController));
        contentPane.getActionMap().put("choose powerup 3", new GameActionHandler("choose powerup 3", gameController));
        contentPane.getActionMap().put("choose powerup 4", new GameActionHandler("choose powerup 5", gameController));

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
    public void onDestroy(GameObject obj1, GameObject obj2) {
        gamePanel.onDestroy(obj1,obj2);
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
