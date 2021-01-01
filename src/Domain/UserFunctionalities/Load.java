package Domain.UserFunctionalities;

import Domain.ObjectCreation.ObjectFactory;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Utils.Position;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Load {

    public Load(){}

    public void LoadTheGame(JSONObject mainJsonObject){
        //System.out.println(mainJsonObject.toJSONString());
        GameData data=new GameData();
        //GameConfiguration.getInstance().setData(data);
        double health= (double) mainJsonObject.get("Health");
        data.setHealth(health);
        double score= (double) mainJsonObject.get("Score");
        data.setScore(score);
        double time= (double) mainJsonObject.get("Time");
        data.setRemainingTime(time);
        String alphaBetaMovement= (String) mainJsonObject.get("AlphaBetaMovement");
        data.setMovementType(alphaBetaMovement);
        String alphaBetaShape= (String) mainJsonObject.get("AlphaBetaShape");
        data.setAlphaBetaType(alphaBetaShape);

        HashMap<String,HashMap<String,Integer>> remainingObjects= new HashMap<>();
        data.setRemainingObjects(remainingObjects);
        HashMap<String,HashMap<String,Integer>> ammunition= new HashMap<>();
        data.setAmmunition(ammunition);
        HashMap<String,Integer> remainingShield= new HashMap<>();
        data.setRemainingShield(remainingShield);
        ArrayList<GameObject> frameObjects=new ArrayList<>();
        data.setFrameObjects(frameObjects);

        JSONArray jsonRemainingObjectArray=(JSONArray) mainJsonObject.get("RemainingObjects");
        for (int i = 0; i < jsonRemainingObjectArray.size(); i++) {
            JSONObject jsonObject= (JSONObject) jsonRemainingObjectArray.get(i);
            String type= (String) jsonObject.get("Type");
            JSONArray jsonArray= (JSONArray) jsonObject.get("Array");
            HashMap<String,Integer> hashMap=new HashMap<>();
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jo= (JSONObject) jsonArray.get(j);
                String subtype= (String) jo.get("Subtype");
                int amount= (int) (long) jo.get("Amount");
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
                int amount= (int) (long) jo.get("Amount");
                hashMap.put(subtype,amount);
            }
            ammunition.put(type,hashMap);
        }

        JSONArray jsonRemainingShieldArray= (JSONArray) mainJsonObject.get("Shield");
        for (int i = 0; i < jsonRemainingShieldArray.size(); i++) {
            JSONObject jo= (JSONObject) jsonRemainingShieldArray.get(i);
            String type= (String) jo.get("Type");
            int amount= (int) (long) jo.get("Amount");
            remainingShield.put(type,amount);
        }


        JSONArray jsonFrameObjectArray= (JSONArray) mainJsonObject.get("FrameObjects");
        ObjectFactory objectFactory=ObjectFactory.getInstance();
        for (int i = 0; i < jsonFrameObjectArray.size(); i++) {
            JSONObject jo= (JSONObject) jsonFrameObjectArray.get(i);
            String type= (String) jo.get("Type");
            String subtype= (String) jo.get("Subtype");
            double xPos= (double) jo.get("XPos");
            double yPos=(double) jo.get("YPos");
            boolean isFallable= (boolean) jo.get("IsFallable");
            Position position=new Position(xPos,yPos);
            GameObject gameObject=objectFactory.createObject(type,subtype,position,isFallable);
            frameObjects.add(gameObject);
        }

        System.out.println(data.toString());

    }
}
