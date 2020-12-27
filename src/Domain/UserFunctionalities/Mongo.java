package Domain.UserFunctionalities;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class Mongo implements SaveLoadAdapter {

    MongoCollection<Document> collection;

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
        String jsonString=my_doc.toJson();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);
        return json;
    }

    @Override
    public boolean upload(JSONObject json) throws Exception {
        collection.insertOne(Document.parse(json.toString()));
        return true;
    }
}
