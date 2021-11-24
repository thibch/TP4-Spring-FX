package fr.ul.tp3_exo2_fx;

import com.sun.jersey.api.client.*;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HTMLManager {

    private WebResource service;
    public HTMLManager() {

    }

    public static String callGETCards() {
        try {
            URL url;
            url = new URL("http://localhost:8081/cards");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println(status);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    public static Card callGETCard(String isbn) {
        try {
            URL url;
            url = new URL("http://localhost:8081/card/" + isbn);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println(status);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            // JSON

            Card card = new Card();

            System.out.println(content.toString());


            if (!content.toString().isEmpty()) {


                JSONParser jsonParser = new JSONParser();
                JSONObject jsonParsed = (JSONObject) jsonParser.parse(content.toString());

                if (jsonParsed.get("id") != null) {
                    card.setId(Integer.parseInt(jsonParsed.get("id").toString()));
                    card.setNom(jsonParsed.get("nom").toString());
                    card.setType(jsonParsed.get("type").toString());
                    card.setNiveau(Integer.parseInt(jsonParsed.get("niveau").toString()));
                }
            }

            return card;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Card();
    }

    public static void callDELETECard(String isbn) {
        try {
            URL url;
            url = new URL("http://localhost:8081/card/" + isbn);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            int status = con.getResponseCode();
            System.out.println(status);
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void callPOSTCard(Card card) {
        try {

            URL url;
            url = new URL("http://localhost:8081/card");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Constructing the json


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"nom\" : \"").append(card.getNom()).append("\", ");
            stringBuilder.append("\"type\" : \"").append(card.getType()).append("\", ");
            stringBuilder.append("\"niveau\" : ").append(card.getNiveau()).append("}");

            System.out.println(stringBuilder.toString());

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = stringBuilder.toString().getBytes();
                os.write(input, 0, input.length);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            con.getInputStream();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void callPUTCard(Card card) {
        try {

            URL url;
            url = new URL("http://localhost:8081/card/" + card.getId());

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Constructing the json


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"nom\" : \"").append(card.getNom()).append("\", ");
            stringBuilder.append("\"type\" : \"").append(card.getType()).append("\", ");
            stringBuilder.append("\"niveau\" : ").append(card.getNiveau()).append("}");

            System.out.println(stringBuilder.toString());

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = stringBuilder.toString().getBytes();
                os.write(input, 0, input.length);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            con.getInputStream();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

