package PartTWO.restapi;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONparser {
	public static void main(String args[]) throws FileNotFoundException{
		System.out.println("here1");
		JsonParser parser = new JsonParser();
		System.out.println("here2");
		FileReader fr =new FileReader("C:\\Users\\Tejas\\Desktop\\searchresultsLA.json");
		System.out.println("here3"+fr);
		Object object = parser.parse(fr);
		System.out.println("here4");
		JsonObject jsonObject = new JsonObject();
		jsonObject = (JsonObject)object;
		System.out.println(jsonObject);
	}
}
