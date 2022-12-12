package kg.charginov.naturallanguageprocessing.http;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RestApis {

    private HttpURLConnection connection;

    public String getText(String function,String text) {
        String line;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        text = URLEncoder.encode(text, StandardCharsets.UTF_8);
        System.out.println(text);
        String response = "";

        try {
            URL url = new URL("http://127.0.0.1:8080/"+ function+ "/?text="+decodeText(text));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(100000);
            connection.setReadTimeout(100000);
            int status = connection.getResponseCode();

            if(status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            response = parse(responseContent.toString());
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String decodeText(String text){
        StringBuilder sb = new StringBuilder();
        for(char ch:text.toCharArray()){
            if(ch==' '){
                sb.append("%20");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private String parse(String responseBody){
        JSONObject textObj = new JSONObject(responseBody);
        return textObj.getString("text");
    }

}
