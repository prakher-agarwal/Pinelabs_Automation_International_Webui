package CommonBase;
import Constants.Paths;
import com.mongodb.client.*;
import org.bson.Document;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;

public class CommonUtils {
    static MongoCollection<Document> tableName;
    static MongoDatabase database;
    static MongoClient client;

    public static Properties readPropertyfile(String propertyFilePath) {

        Properties p = null;
        try {
            FileReader reader = new FileReader(propertyFilePath);
            p = new Properties();
            p.load(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    public static MongoDatabase dbValidation() {

        client = MongoClients.create(CommonUtils.readPropertyfile(Paths.dbPropertiesPath).getProperty("mongoDbconnectionURL"));
        MongoIterable<String> dbname = client.listDatabaseNames();
        for (String db : dbname) {
            if (db.equals("admin")) {
                database = client.getDatabase(db);
                System.out.println("Connected to admin database");
            }
        }
        return database;
    }

    public static MongoCollection<Document> findCollectionFromDb(String collectionName) {
        dbValidation();
        tableName = database.getCollection(collectionName);
        return tableName;
    }

    public static Document findRowBasedOnColumn(String collectionName, String columnName, Object columnValue) {
        findCollectionFromDb(collectionName);
        return tableName.find(eq(columnName, columnValue)).first();
    }

    public static FindIterable<Document> sortWithcolumnName(String collectionName, String columnName) {
        tableName = findCollectionFromDb(collectionName);
        return tableName.find().sort(ascending(columnName));
    }

    public static Document findRowBasedOnHardwareID(String collectionName, String hardwareId) {
        tableName = findCollectionFromDb(collectionName);
        return tableName.find(eq("HARDWARE_ID", hardwareId)).first();
    }

    public static void closeConnection() {
        client.close();
    }

    public static int generateRandonNumber(int length) {
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length); // bound is exclusive
        Random random = new Random();
        return random.nextInt(max - min) + min;

    }




}
