package com.waracle.cakemgr.model;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

class CakeTest {

	private static Cake cake;
	private static String desc;
	private static Gson gson;
	private static String image;
	private static String json;
	private static String title;
	private static String url;

	@BeforeAll
	static void setup() {
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		url = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";
		json = "{\"title\":\"Carrot cake\",\"desc\":\"Bugs bunnys favourite\",\"image\":\"http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg\"}";
		title = "Carrot cake";
		desc = "Bugs bunnys favourite";
		image = "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg";
		cake = new Cake(title, desc, image);
	}

	@Test
	void testCreateCakeObjectFromJsonString() {
		Cake cake = gson.fromJson(json, Cake.class);
		assertEquals("Carrot cake", cake.getTitle(), "Cake title property incorrect");
		assertEquals("Bugs bunnys favourite", cake.getDescription(), "Cake description property incorrect");
		assertEquals("http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg", cake.getImage(),
				"Cake image property incorrect");
	}

	@Test
	void testParseJsonDataFile() throws MalformedURLException, IOException {
		try (InputStreamReader reader = new InputStreamReader(new URL(url).openStream());) {
			List<Cake> cakes = gson.fromJson(reader, new TypeToken<ArrayList<Cake>>() {
			}.getType());
			assertThat(cakes, not(IsEmptyCollection.empty()));
			assertThat(cakes, hasSize(20));
			assertThat(cakes, hasItems(cake));
		}
	}
}
