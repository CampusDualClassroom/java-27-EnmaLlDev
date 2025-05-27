package com.campusdual.classroom;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise27 {
    public static void main(String[] args) {

        createJSON("src/main/resources/shoppingList.json");
        createXML("src/main/resources/shoppingList.xml");

    }

    public static void createJSON(String rutaJSON) {
        try {
            FileReader fileReader = new FileReader(rutaJSON);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray itemsArray = jsonObject.getAsJsonArray("items");
            System.out.println(itemsArray.size());

        } catch (IllegalStateException e) {
            System.err.println("Error: El archivo no contiene un objeto JSON válido");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el archivo");
            e.printStackTrace();
        }
    }
    public static void createXML(String rutaXML) {
        try{
            FileReader fileReader = new FileReader(rutaXML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(fileReader));

        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el archivo XML");
            e.printStackTrace();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Error al parsear el archivo XML");
            e.printStackTrace();
        }
    }

}



/*
            for(Map.Entry<String, JsonElement> items : jsonObject.entrySet()){
                String producto = items.getKey(); //String
                JsonElement cantidad = items.getValue(); //JsonElement
                System.out.println(
                        "Producto: " + producto +
                        ", Cantidad: " + cantidad
                );
            }
        */

