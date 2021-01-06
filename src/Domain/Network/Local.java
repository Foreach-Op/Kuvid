package Domain.Network;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Local implements SaveLoadAdapter {


    List<String> savedFilenames=new ArrayList<>();

    @Override
    public JSONObject download(String filename) throws Exception {

        return getJson(filename);
    }

    @Override
    public boolean upload(JSONObject json) throws Exception {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        FileWriter file = null;

        try {
            fw = new FileWriter("save_files/saved_games.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(json.get("username"));
            pw.flush();

            file = new FileWriter("save_files/" + json.get("username") + ".json");
            file.write(json.toJSONString());
            file.flush();

        } finally {
            file.close();
            pw.close();
            bw.close();
            fw.close();
        }
        return true;

    }

    @Override
    public List<HashMap<String, String>> savedFiles() throws Exception { //if you need other variables, return savedGames
        List<HashMap<String, String>> savedGames=new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            File myObj = new File("ave_files/saved_games.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                savedFilenames.add(data);
                JSONObject json=getJson(data);
                HashMap<String, String> gameMap=new HashMap<>();
                gameMap.put("title", (String) json.get("title"));
                gameMap.put("username",(String) json.get("username"));
                gameMap.put("score",df.format((double) json.get("Score")));
                gameMap.put("time",df.format((double) json.get("Time")));
                gameMap.put("health",df.format((double) json.get("Health")));
                savedGames.add(gameMap);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound in Local.");
            e.printStackTrace();
        }
        return savedGames;
    }

    private JSONObject getJson(String filename) throws Exception{
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(new File("save_files/"+filename+".json"));
        Object obj = jsonParser.parse(reader);
        JSONObject json = (JSONObject) obj;

        return json;
    }
}
