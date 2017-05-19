package jsonexample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonBasic {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Employee", "Miral");
		System.out.println(jsonObject);
		System.out.println(jsonObject.get("Employee"));
		
		JSONArray array = new JSONArray();
		array.add("MIral");
		System.out.println(array);
		array.add(jsonObject);
		System.out.println(array);
		JSONArray arr = new JSONArray();
		arr.add(array);
		System.out.println(arr);
		arr=(JSONArray) arr.get(0);
		System.out.println(arr);
		
		String str = (String) arr.get(0);
		System.out.println(str);
		JSONObject jsp =(JSONObject) arr.get(1);
		System.out.println(arr.get(1));
		
		System.out.println(jsp.get("Employee"));
	
	}
}
