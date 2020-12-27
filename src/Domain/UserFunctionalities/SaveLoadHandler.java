package Domain.UserFunctionalities;

public class SaveLoadHandler {

    //burası çağırılarak yapılabilir.
    private SaveLoadAdapter adapter;

    public SaveLoadHandler(){
        LocalMongoFactory fac=new LocalMongoFactory();
        adapter=fac.getAdapter();
    }



    public void Save(){

    }

    public void Load(){

    }





}
