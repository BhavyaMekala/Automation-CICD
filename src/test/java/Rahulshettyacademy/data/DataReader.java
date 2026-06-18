package Rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public  List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		//Read Json to String
		//readFileToString is depricated, in the newest method wt they did is apart from first argument ,
		//when it is trying to read json to string it is also asking 
		//in what encoding format your trying to write the string, so standar encoding formating is StandardCharsets.UTF_8 
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Rahulshettyacademy\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
	
		//String to HashMap- jackson Databind
		//readValue which can read the String and convert to Hashmap, which expects 2 arguments, one is string what i want to convert and second argument how we want to convert , go ahead creates hashmaps in the form of list 
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	

}
