package Domain.UserFunctionalities;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class Mongo implements SaveLoadAdapter {

    MongoCollection<Document> collection;
    List<String> savedFilenames=new ArrayList<>();
    List<JSONObject> savedGames=new ArrayList<>();

    public Mongo(){
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); // e.g. or Log.WARNING, etc.
        MongoClient mongoClient = MongoClients.create("mongodb+srv://comp302_user:comp302_password@sandbox.v2mqr.mongodb.net/"); // uri connection to the server
        MongoDatabase database = mongoClient.getDatabase("Comp302"); // selecting the database
        this.collection = database.getCollection("KuvidCollection"); // collection
    }


    @Override
    public JSONObject download(String filename) throws Exception {
        Document my_doc = collection.find(eq("username", filename)).first();
        return changetoJson(my_doc);
    }

    @Override
    public boolean upload(JSONObject json) throws Exception {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("save_files/saved_games.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(json.get("username"));
            pw.flush();

        } finally {
            pw.close();
            bw.close();
            fw.close();
        }

        collection.insertOne(Document.parse(json.toString()));
        return true;
    }

    @Override
    public List<String> savedFiles() throws Exception {//if you need other variables, return savedGames
        try {
            File myObj = new File("ave_files/saved_games.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                savedFilenames.add(data);

                Document my_doc = collection.find(eq("username", data)).first();
                JSONObject json=changetoJson(my_doc);
                savedGames.add(json);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return savedFilenames;
    }


    private JSONObject changetoJson(Document my_doc) throws Exception{
        String jsonString=my_doc.toJson();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);
        return json;
    }
}
