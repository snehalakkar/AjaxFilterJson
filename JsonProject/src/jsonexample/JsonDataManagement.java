package jsonexample;

import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonDataManagement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("name", "basmati");
		json.put("weight", 20);
		json.put("price", 50);
		jsonArray.add(json);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "normal");
		jsonObj.put("weight", 30);
		jsonObj.put("price", 40);
		jsonArray.add(jsonObj);
		jsonObject.put("Rice", jsonArray);

		JSONArray jsonArray1 = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("name", "lokvan");
		json1.put("weight", 20);
		json1.put("price", 60);
		jsonArray1.add(json1);

		JSONObject jsonObj1 = new JSONObject();
		jsonObj1.put("name", "normal");
		jsonObj1.put("weight", 30);
		jsonObj1.put("price", 40);
		jsonArray1.add(jsonObj1);

		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("name", "costly");
		jsonObj2.put("weight", 10);
		jsonObj2.put("price", 90);
		jsonArray1.add(jsonObj2);
		jsonObject.put("Wheat", jsonArray1);

		JSONArray jsonArray2 = new JSONArray();
		JSONObject json2 = new JSONObject();
		json2.put("name", "chana");
		json2.put("weight", 20);
		json2.put("price", 60);
		jsonArray2.add(json2);

		JSONObject jsonObj3 = new JSONObject();
		jsonObj3.put("name", "mugdal");
		jsonObj3.put("weight", 30);
		jsonObj3.put("price", 40);
		jsonArray2.add(jsonObj3);
		jsonObject.put("Pulses", jsonArray2);

		System.out.println(jsonObject);
		System.out.println("Iterating json object .....");

		Iterator<JSONObject> iterator = jsonObject.values().iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("\n\nchoices are: 1.Pulses  2.Wheat  3.Rice  ");
		System.out.println("\n Enter the your choice....");
		String choice = scanner.next();
		System.out.println("Enter the particular type of " + choice + " u want ");
		String choice1 = scanner.next();
		JSONArray jsonArray3 = new JSONArray();
		JSONObject jsonObject2 = new JSONObject();

		jsonArray3 = (JSONArray) jsonObject.get(choice);
		for (int i = 0; i < jsonArray3.size(); i++) {
			jsonObject2 = (JSONObject) jsonArray3.get(i);
			if (((String) jsonObject2.get("name")).equalsIgnoreCase(choice1)) {
				System.out.println("\nname is :" + jsonObject2.get("name"));
				System.out.println("\nweight in kg :" + jsonObject2.get("weight"));
				System.out.println("\nprice is :" + jsonObject2.get("price"));
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("sorry ,this type of " + choice + " is not available...");
		}
	}
}
