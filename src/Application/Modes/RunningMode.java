package Application.Modes;


import Domain.Objects.GameObject;

public class RunningMode {
    private static RunningMode runningMode;

    private RunningMode(){}

    public static RunningMode getInstance(){
        if(runningMode ==null){
            runningMode =new RunningMode();
        }
        return runningMode;
    }

    public void killObj(GameObject gameObject) {
        //increase score --> Score in Player class,
        //destroy GameObj -->

    }

}
