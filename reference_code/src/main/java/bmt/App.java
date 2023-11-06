package bmt;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException, FileNotFoundException
    {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(".\\response.json");
        Object obj =  jsonparser.parse(reader);
        JSONObject weatherjson = (JSONObject) obj;
        JSONObject hourlyreport = (JSONObject) weatherjson.get("hourly");
        JSONArray arrTime = (JSONArray) hourlyreport.get("time");
        JSONArray arrTemp = (JSONArray) hourlyreport.get("temperature_2m");
        //JSONArray arrRain = (JSONArray) hourlyreport.get("rain");
        String givenTime = "2023-10-30T01:00";
        int loc = 0;
        for (int i = 0; i<arrTime.size(); i++){
            if (givenTime.equals(arrTime.get(i))){
                loc = i;
            }
        }
        System.out.println(arrTemp.get(loc));
    }
}
