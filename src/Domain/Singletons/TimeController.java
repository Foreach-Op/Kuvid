package Domain.Singletons;

public class TimeController {
    private static TimeController timeController;

    private TimeController(){}

    public static TimeController getInstance(){
        if(timeController==null){
            timeController=new TimeController();
        }
        return timeController;
    }
}
