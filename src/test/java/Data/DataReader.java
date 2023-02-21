package Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class DataReader {

	

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		String jsonString = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src/test//java/Data//PurchaseOrder.json"),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonString, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		
		return data;
	
	}
	
}
