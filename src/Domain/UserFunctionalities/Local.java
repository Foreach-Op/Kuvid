package Domain.UserFunctionalities;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Local implements SaveLoadAdapter {


    List<String> savedFilenames=new ArrayList<>();
    List<JSONObject> savedGames=new ArrayList<>();

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
    public List<String> savedFiles() throws Exception { //if you need other variables, return savedGames
        try {
            File myObj = new File("ave_files/saved_games.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                savedFilenames.add(data);

                JSONObject json=getJson(data);
                savedGames.add(json);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return savedFilenames;
    }

    private JSONObject getJson(String filename) throws Exception{
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(new File("save_files/"+filename+".json"));
        Object obj = jsonParser.parse(reader);
        JSONObject json = (JSONObject) obj;

        return json;
    }
}
