import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 
public class GoEuroRestClient {
 
	public static void main(String[] args)  throws IOException{
 
	
	  try {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the name of the city:");
		
		String city = in.readLine();
 
		URL url = new URL("http://api.goeuro.com/api/v2/position/suggest/en/"+city);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output,json="";
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			json+=output;
		}
 
		conn.disconnect();
		
		String jsonString;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		Gson gson = gsonBuilder.create();
		
		List<LocationInfoDTO> locationInfoList = new ArrayList<LocationInfoDTO>();
		
		List<Geoposition> geoPositionList = new ArrayList<>();
		
		JSONArray array = new JSONArray(json);
		
		for(int i=0;i<array.length();i++){
			LocationInfoDTO location = gson.fromJson(array.getJSONObject(i).toString(), LocationInfoDTO.class);
			Geoposition geo_position = gson.fromJson(array.getJSONObject(i).getJSONObject("geo_position").toString(),Geoposition.class);
			locationInfoList.add(location);
			geoPositionList.add(geo_position);
		}
		
		WriteToCSV writer=new WriteToCSV();
		if(writer.writeToCsv(locationInfoList, geoPositionList,"F:\\"+city+".csv"))
			System.out.println("File generated and stored as "+"F:\\"+city+".csv");
		else
			System.out.println("Some problem occured");
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}