package Domain.Singletons;

public class GameStatueController {

    private static GameStatueController singleton;

    private boolean isPaused=false;
    private boolean isEnded=false;

    private GameStatueController(){}

    public synchronized static GameStatueController getInstance() {
        if(singleton==null){
            singleton=new GameStatueController();
        }
        return singleton;
    }

    public boolean isGamePaused(){
        return isPaused;
    }

    public void setPaused(){
        this.isPaused=true;
    }

    public void setResumed(){
        this.isPaused=false;
    }

    public boolean isGameEnded(){
        return isEnded;
    }

    public void setGameEnded(){
        this.isEnded=true;
    }
}
