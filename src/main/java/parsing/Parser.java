package parsing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Product> list;

    public Parser(String fileAddress) {
        this.list = catalogJson(readFromFile(fileAddress));
    }

    public List<Product> getList() {
        return list;
    }

    public static String readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                text.append(s);
            }
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> catalogJson(String json) {
        List<Product> products = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            JSONArray jsonObject = (JSONArray) obj;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            for (Object o :
                    jsonObject) {
                products.add(gson.fromJson(o.toString(), Product.class));
            }
            return products;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void printCatalog() {
        for (Product product :
                list) {
            System.out.println(product);
        }
    }
}
