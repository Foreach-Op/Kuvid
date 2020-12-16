package Domain.DomainControl;

import Domain.Functionalities.GameStatueControl;
import Domain.Objects.*;
import Domain.ShooterFunctions.Shooter;
import Domain.Statistics.GameConfiguration;
import Domain.Collision.CollisionHandler;
import Domain.Movement.MovementHandler;
import Domain.ObjectCreator.ObjectCreationHandler;
import Domain.ShooterFunctions.ShooterHandler;
import Domain.Utils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class RunningMode {

    private ObjectListener frameListener;

    private ArrayList<GameObject> frameObjects;
    CopyOnWriteArrayList<GameObject> frameObjects2=new CopyOnWriteArrayList<>();


    private HashMap<String, HashMap<String, Integer>> objectsToBeProduced = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> ammunition = new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    private Timer timerObjectCreation;
    private Timer timerMoveAndCollision;
    private Timer timerClock;
    private Timer timerFunction;
    private TimerTask functionTask;
    private TimerTask createObjectTask;
    private TimerTask moveAndCollideTask;
    private TimerTask clockTask;
    public ObjectCreationHandler objectCreationHandler; //static?
    ShooterHandler shooterHandler;
    public double clock;

    public int moveCollidePeriod;
    public int objectCreationPeriod;
    public int clockPeriod;

    public int clockCounter;
    public int creationCounter;


    //private int refreshRate;

    public RunningMode(ObjectListener frameListener) {
        setFrameListener(frameListener);
        frameObjects = new ArrayList<>();
    }


    public void startGame() {
        clock=GameConfiguration.getInstance().getData().getRemainingTime();
        moveCollidePeriod=20;
        clockPeriod=100;
        objectCreationPeriod=setCreationTime();
        clockCounter=0;
        creationCounter=0;

        shooterHandler=new ShooterHandler(frameListener);
        Shooter shooter=shooterHandler.createShooter();
        frameObjects2.add(shooter);

        objectCreationHandler = new ObjectCreationHandler(frameObjects2, frameListener);
        movementHandler = new MovementHandler(frameObjects2, frameListener);
        collisionHandler = new CollisionHandler(frameObjects2, frameListener);
        timerFunction=new Timer();
        //timerObjectCreation=new Timer();
        //timerMoveAndCollision=new Timer();
        //timerClock=new Timer();

        //refreshRate = 10;
        //int creationTime = setCreationTime();
        functionTask=timerFunctions();
        //createObjectTask = createObject();
        //moveAndCollideTask = moveAndCollide();
        //clockTask=clock();
        timerFunction.scheduleAtFixedRate(functionTask,10,moveCollidePeriod);
        //timerObjectCreation.scheduleAtFixedRate(createObjectTask,10,creationTime);
        //timerMoveAndCollision.scheduleAtFixedRate(moveAndCollideTask,20,20);
        //timerClock.scheduleAtFixedRate(clockTask,0,100);

    }

    public void setFrameListener(ObjectListener frameListener) {
        this.frameListener = frameListener;
    }

    private TimerTask timerFunctions(){
        return new TimerTask() {
            @Override
            public void run() {
                movementHandler.move();
                collisionHandler.collisionDetect();

                if(clockCounter==clockPeriod){
                    clock=clock-0.1;
                    GameConfiguration.getInstance().setTime(clock);
                    if(clock<=0){
                        GameConfiguration.getInstance().setTime(0.0);
                        GameStatueControl.getInstance().setGameEnded();
                    }
                    clockCounter=0;
                }

                if(creationCounter==objectCreationPeriod){
                    objectCreationHandler.createRandomFallingObject();
                    creationCounter=0;
                }

                clockCounter=clockCounter+moveCollidePeriod;
                creationCounter=creationCounter+moveCollidePeriod;

                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }



    private TimerTask moveAndCollide() {

        return new TimerTask() {
            @Override
            public void run() {
                movementHandler.move();
                collisionHandler.collisionDetect();
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }


    private TimerTask createObject() {

        return new TimerTask() {
            @Override
            public void run() {

                objectCreationHandler.createRandomFallingObject();
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }


    private TimerTask clock() {

        return new TimerTask() {
            @Override
            public void run() {

                clock=clock-0.1;
                GameConfiguration.getInstance().setTime(clock);
                if(clock<=0){
                    GameConfiguration.getInstance().setTime(0.0);
                    GameStatueControl.getInstance().setGameEnded();
                }
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }

    public void pauseGame(){
        //createObjectTask.cancel();
        //moveAndCollideTask.cancel();
        //clockTask.cancel();
        //timerObjectCreation.cancel();
        //timerMoveAndCollision.cancel();
        //timerClock.cancel();
        functionTask.cancel();
        timerFunction.cancel();
        GameStatueControl.getInstance().setPaused();
    }
    public void resumeGame(){
        //createObjectTask = createObject();
        //moveAndCollideTask = moveAndCollide();
        //clockTask=clock();
        //timerObjectCreation=new Timer();
        //timerMoveAndCollision=new Timer();
        //timerClock=new Timer();
        //timerObjectCreation.scheduleAtFixedRate(createObjectTask,10,setCreationTime());
        //timerMoveAndCollision.scheduleAtFixedRate(moveAndCollideTask,20,20);
        //timerClock.scheduleAtFixedRate(clockTask,0,100);
        timerFunction=new Timer();
        functionTask=timerFunctions();
        timerFunction.scheduleAtFixedRate(functionTask,10,moveCollidePeriod);
        GameStatueControl.getInstance().setResumed();
    }

    private void endGame(){
        pauseGame();
        //GameOver()
    }

    private int setCreationTime() {
        int time = 0;
        switch (GameConfiguration.getInstance().getData().getDifficulty()) {
            case HARD:
                time = 250;
                break;
            case NORMAL:
                time = 500;
                break;
            case EASY:
                time = 1000;
                break;
        }
        return time;
    }

}
