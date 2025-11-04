package practica.restaurants;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author alfre
 */
public class Restaurants {

    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase db = client.getDatabase("RestauratsDB");
        MongoCollection<Document> col = db.getCollection("restaurants");
        

        ArrayList<Document> lista = new ArrayList<>();
//        lista.add(new Document("name", "Cafe de la plaza")
//                .append("stars", 4.3)
//                .append("categorias", Arrays.asList(new String[]{"Cafe", "Postres", "Desayunos"}))
//        );
        
        lista.add(new Document("name", "Expresso express")
                .append("stars", 4.8)
                .append("categorias", Arrays.asList(new String[]{"Cafe", "Rapido", "Takeaway"}))
        );
        
        lista.add(new Document("name", "The tea house")
                .append("stars", 3.9)
                .append("categorias", Arrays.asList(new String[]{"Te", "Infusiones", "Postres"}))
        );
        
        lista.add(new Document("name", "Morning brew")
                .append("stars", 4.0)
                .append("categorias", Arrays.asList(new String[]{"Cafe", "Desayuno", "Bakery"}))
        );
        col.insertMany(lista);
        
//        for (Document d: col.find(Filters.eq("name", "Sushilito"))){
//            System.out.println(d.toJson());
//        }
//        
//        for (Document d: col.find(Filters.gt("stars", 4))){
//            System.out.println(d.toJson());
//        }
//        
//        Bson filtro = Filters.and(Filters.gte("stars", 3), Filters.lte("stars", 4));
//        for (Document d: col.find(filtro)){
//            System.out.println(d.toJson());
//        }
//        
//        for (Document d: col.find(Filters.in("categorias", Arrays.asList("Pizza", "Hamburguesas", "Bebidas")))){
//            System.out.println(d.toJson());
//        }
//        
//        for (Document d: col.find(Filters.regex("name", "o$"))){
//            System.out.println(d.toJson());
//        }
//        
//        col.updateOne(Filters.eq("name", "Sushilito"), Updates.set("stars", 4.5));
//        col.updateOne(Filters.eq("name", "Sushilito"), Updates.set("telefono", "1234567890"));
//        col.updateOne(Filters.eq("_id", new ObjectId("69095f0259cf1cf0ab607388")), Updates.inc("stars", 1));
//        
//        col.deleteOne(Filters.eq("_id", new ObjectId("69096199d449ff91c5b7f332")));
    }
}
