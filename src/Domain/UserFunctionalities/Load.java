package Domain.UserFunctionalities;

import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Load {
    private String fileName="";

    public Load(String fileName){
        this.fileName=fileName;
    }

    public GameData LoadTheGame(JSONObject mainJsonObject){
        GameData data=new GameData();

        double health= (double) mainJsonObject.get("Health");
        double score= (double) mainJsonObject.get("Score");
        double time= (double) mainJsonObject.get("Time");
        String alphaBetaMovement= (String) mainJsonObject.get("AlphaBetaMovement");
        String alphaBetaShape= (String) mainJsonObject.get("AlphaBetaShape");

        HashMap<String,HashMap<String,Integer>> remainingObjects= new HashMap<>();
        HashMap<String,HashMap<String,Integer>> ammunition= new HashMap<>();
        HashMap<String,Integer> remainingShielded= new HashMap<>();

        JSONArray jsonRemainingObjectArray=(JSONArray) mainJsonObject.get("RemainingObjects");
        for (int i = 0; i < jsonRemainingObjectArray.size(); i++) {
            JSONObject jsonObject= (JSONObject) jsonRemainingObjectArray.get(i);
            String type= (String) jsonObject.get("Type");
            JSONArray jsonArray= (JSONArray) jsonObject.get("Array");
            HashMap<String,Integer> hashMap=new HashMap<>();
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jo= (JSONObject) jsonArray.get(j);
                String subtype= (String) jo.get("Subtype");
                int amount= (int) jo.get("Amount");
                hashMap.put(subtype,amount);
            }
            remainingObjects.put(type,hashMap);
        }

        JSONArray jsonAmmunitionArray= (JSONArray) mainJsonObject.get("Ammunition");
        for (int i = 0; i < jsonAmmunitionArray.size(); i++) {
            JSONObject jsonObject= (JSONObject) jsonAmmunitionArray.get(i);
            String type= (String) jsonObject.get("Type");
            JSONArray jsonArray= (JSONArray) jsonObject.get("Array");
            HashMap<String,Integer> hashMap=new HashMap<>();
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jo= (JSONObject) jsonArray.get(j);
                String subtype= (String) jo.get("Subtype");
                int amount= (int) jo.get("Amount");
                hashMap.put(subtype,amount);
            }
            ammunition.put(type,hashMap);
        }

        JSONArray jsonRemainingShieldArray= (JSONArray) mainJsonObject.get("Shield");
        for (int i = 0; i < jsonRemainingShieldArray.size(); i++) {
            JSONObject jo= (JSONObject) jsonRemainingShieldArray.get(i);
            String type= (String) jo.get("Type");
            int amount= (int) jo.get("Amount");
            remainingShielded.put(type,amount);
        }


        /*JSONArray jsonFrameObjectArray= (JSONArray) mainJsonObject.get("FrameObjects");
        for (int i = 0; i < frameObjects.size(); i++) {
            GameObject currentObject=frameObjects.get(i);
            String type=currentObject.getType();
            String subtype=currentObject.getSubType();
            double xPos=currentObject.getX();
            double yPos=currentObject.getY();
            JSONObject jo=new JSONObject();
            jo.put("Type",type);
            jo.put("Subtype",subtype);
            jo.put("XPos",xPos);
            jo.put("YPos",yPos);
            jsonFrameObjectArray.add(jo);
        }*/





        return data;
    }
}
