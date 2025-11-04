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
        
//
//        ArrayList<Document> lista = new ArrayList<>();
//        lista.add(new Document("name", "Cafe de la plaza")
//                .append("stars", 4.3)
//                .append("categorias", Arrays.asList(new String[]{"Cafe", "Postres", "Desayunos"}))
//        );
        
//        lista.add(new Document("name", "Expresso express")
//                .append("stars", 4.8)
//                .append("categorias", Arrays.asList(new String[]{"Cafe", "Rapido", "Takeaway"}))
//        );
//        
//        lista.add(new Document("name", "The tea house")
//                .append("stars", 3.9)
//                .append("categorias", Arrays.asList(new String[]{"Te", "Infusiones", "Postres"}))
//        );
//        
//        lista.add(new Document("name", "Morning brew")
//                .append("stars", 4.0)
//                .append("categorias", Arrays.asList(new String[]{"Cafe", "Desayuno", "Bakery"}))
//        );
//        col.insertMany(lista);
        
//        System.out.println("-----Documentos con stars >= 4.5-----");
//        for (Document d : col.find(Filters.gte("stars", 4.5))) {
//            System.out.println(d.toJson());
//        }
//
//        System.out.println("\n-----Documentos cuyo nombre contiene 'Cafe'-----");
//        for (Document d : col.find(Filters.regex("name", "Cafe"))) {
//            System.out.println(d.toJson());
//        }
//
//        System.out.println("\n-----Documentos con categories que incluyan 'Postres'-----");
//        for (Document d : col.find(Filters.eq("categorias", "Postres"))) {
//            System.out.println(d.toJson());
//        }
//
//        System.out.println("\n-----Documentos con stars entre 3 y 4.3-----");
//        Bson filtro_rango = Filters.and(Filters.gte("stars", 3), Filters.lte("stars", 4.3));
//        for (Document d : col.find(filtro_rango)) {
//            System.out.println(d.toJson());
//        }
//
//        System.out.println("\n-----Documentos cuyo nombre empieza con 'T'-----");
//        for (Document d : col.find(Filters.regex("name", "^T"))) {
//            System.out.println(d.toJson());
//        }

//        System.out.println("-----Actualizado 'Morning brew'-----");
//        col.updateOne(Filters.eq("name", "Morning brew"), Updates.set("stars", 4.5));
//        
//        System.out.println("-----Incrementado +0.2 stars a 'Bakery' o 'Desayuno'-----");
//        Bson filtro_cats = Filters.in("categorias", Arrays.asList("Bakery", "Desayuno"));
//        col.updateMany(filtro_cats, Updates.inc("stars", 0.2));
//
//        System.out.println("-----Agregados campos a 'Cafe de la plaza'-----");
//        col.updateOne(Filters.eq("name", "Cafe de la plaza"), Updates.set("phone", "555-111-2222"));
//        col.updateOne(Filters.eq("name", "Cafe de la plaza"), Updates.set("open", true));
//    }

        System.out.println("-----Eliminado 'Espresso express'-----");
        col.deleteOne(Filters.eq("name", "Espresso express"));

        System.out.println("-----Eliminados documentos con stars < 4-----");
        col.deleteMany(Filters.lt("stars", 4));

        System.out.println("-----Eliminados documentos de 'Takeaway' o 'Infusiones'-----");
        Bson fil = Filters.in("categorias", Arrays.asList("Takeaway", "Infusiones"));
        col.deleteMany(fil);
    }
}