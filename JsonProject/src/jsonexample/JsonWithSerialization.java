package jsonexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWithSerialization {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		boolean flag = false;
		String s1 = "";
		String line = "";

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

		System.out.println("Serializing json file...");
		try {
			fileWriter = new FileWriter("/home/bridgeit/JavaPrograms/JsonProject/file.txt");
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.flush();
			System.out.println("\n Successfully writen json object into the file...");
			System.out.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			fileReader = new FileReader("/home/bridgeit/JavaPrograms/JsonProject/file.txt");
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				s1 = s1 + line + " ";
			}
			System.out.println(s1);
			System.out.println("\n Successfully reading json object from file....");
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonobj = (JSONObject) parser.parse(s1);
		System.out.println("parse json object :" + jsonobj);

		jsonObject = jsonobj;
		System.out.println("converted :" + jsonObject);

		System.out.println("\n do you want to add Rice,Wheat,or Pulses ?(y/n) ");
		String ans = scanner.next();

		if (ans.equalsIgnoreCase("y")) {

			System.out.println("Enter the type of product you want.....");
			String ans1 = scanner.next();
			if (ans1.equalsIgnoreCase("Rice")) {
				jsonArray = (JSONArray) jsonobj.get(ans1);

				json.put("name", "newquality");
				json.put("weight", 30);
				json.put("price", 70);
				jsonArray.add(json);
				jsonobj.put("Rice", jsonArray);
			} else if (ans1.equalsIgnoreCase("Wheat")) {
				jsonArray1 = (JSONArray) jsonobj.get(ans1);

				json1.put("name", "newquality");
				json1.put("weight", 30);
				json1.put("price", 70);
				jsonArray1.add(json1);
				jsonobj.put("Wheat", jsonArray1);
			} else {
				jsonArray2 = (JSONArray) jsonobj.get(ans1);

				json2.put("name", "newquality");
				json2.put("weight", 30);
				json2.put("price", 70);
				jsonArray2.add(json2);
				jsonobj.put("Pulses", jsonArray2);
			}
		}

		System.out.println("final json " + jsonobj);
		try {
			fileWriter = new FileWriter("/home/bridgeit/JavaPrograms/JsonProject/file.txt");
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.flush();
			System.out.println("\n Successfully writen json object into the file...");
			System.out.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
