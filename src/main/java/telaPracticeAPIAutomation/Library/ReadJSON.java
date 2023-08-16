package telaPracticeAPIAutomation.Library;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> readJSONFile(String jsonFileName, String objectKey) throws Exception
	{
		if(objectKey==null || objectKey.trim().isEmpty())
		{
			throw new Exception("Object Key must not be null or empty");
		}
		// parsing json file
        Object obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+jsonFileName));
        JSONObject json = (JSONObject)obj;
        if(!json.containsKey(objectKey))
        {
        	throw new Exception("Provided object not present");
        }
        return ((Map<String, Object>)json.get(objectKey));
		
	}

}
