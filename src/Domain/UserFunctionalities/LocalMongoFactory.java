package Domain.UserFunctionalities;

public class LocalMongoFactory {

    private static SaveLoadAdapter adapter;

    public static SaveLoadAdapter getAdapter(){
        String envVariable=System.getenv("saveType");
        if(envVariable.equals("DB")){
            adapter=new Mongo();
        } else{
            adapter=new Local();
        }
        //adapter=new Local();

        return adapter;
    }




}
