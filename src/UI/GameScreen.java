package UI;

import Domain.Objects.ObjectListener;
import Domain.Modes.RunningMode;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class GameScreen extends JFrame implements ObjectListener {

    public HashMap<GameObject, ObjectPanel> hashMap = new HashMap<>();
    private StatisticsWindow statisticsWindow;
    private JFrame gameScreen;

    public GameScreen() {
        CreateUIElements();
        GameActionListener();
    }

    public void SetInitialData(){
        statisticsWindow.SetData(GameConfiguration.getInstance().getData());
    }

    private void CreateUIElements() {
        gameScreen = new JFrame();
        gameScreen.setSize(600, 400);
        gameScreen.setVisible(true);

        statisticsWindow = new StatisticsWindow();
        GameConfiguration.getInstance().setStaticWindowListener(statisticsWindow);

        gameScreen.add(statisticsWindow);
    }

    private void GameActionListener() {
        final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

        JPanel contentPane = (JPanel) gameScreen.getContentPane();

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), "move left");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), "move right");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), "rotate left");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "rotate right");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), "fire");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), "pick atom");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("B"), "blend");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("P"), "pause");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("R"), "resume");

        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "save");
        contentPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("L"), "load");

        contentPane.getActionMap().put("fire", new DummyAction("fire"));
        contentPane.getActionMap().put("move left", new DummyAction("move left"));
        contentPane.getActionMap().put("move right", new DummyAction("move right"));
        contentPane.getActionMap().put("rotate left", new DummyAction("rotate left"));
        contentPane.getActionMap().put("rotate right", new DummyAction("rotate right"));
        contentPane.getActionMap().put("pick atom", new DummyAction("pick atom"));
        contentPane.getActionMap().put("blend", new DummyAction("blend"));
        contentPane.getActionMap().put("pause", new DummyAction("pause"));
        contentPane.getActionMap().put("resume", new DummyAction("resume"));
    }

    public void addObjectPanel(ObjectPanel objectPanel) {
        this.add(objectPanel);
    }

    @Override
    public void onCreate(GameObject obj) {
        ObjectPanel objectPanel = new ObjectPanel(obj.getType(), obj.getSubType(), obj.position());
        hashMap.put(obj, objectPanel);
        this.add(objectPanel);
    }

    @Override
    public void onLocationChange() {
        for (GameObject object : hashMap.keySet()) {
            hashMap.get(object).updatePosition(object.position());
        }
    }

    @Override
    public void onDestroy(GameObject obj1, GameObject obj2) {
        removeFromScreen(obj1);
        removeFromScreen(obj2);
    }

    public void removeFromScreen(GameObject object) {
        if (!object.isAlive()) {
            ObjectPanel panel = hashMap.remove(object);
            this.remove(panel);
        }
    }

    public void initialize(RunningMode runningMode) {
        runningMode.setFrameListener(this);
    }



    private class DummyAction extends AbstractAction {
        private String action;

        DummyAction(String action) {
            this.action = action;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(action);
        }
    }
}
