package com.waracle.cakemgr.service;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.waracle.cakemgr.app.Application;
import com.waracle.cakemgr.model.Cake;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class CakeServiceImplTest {

	private static Cake carrotCake;

	private static String desc;
	private static String image;
	private static String title;

	@BeforeAll
	static void setup() {
		title = "Carrot cake";
		desc = "Bugs bunnys favourite";
		image = "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg";
		carrotCake = new Cake(title, desc, image);
	}

	@Autowired
	private CakeService cakeService;

	private Cake createTestCake() {
		Cake cake = new Cake();
		cake.setTitle("Test cake title cake service");
		cake.setDescription("Test cake description cake service");
		cake.setImage("https://someurl.com/cake.jpg");
		return cake;
	}

	@Test
	void testSaveCake() {
		Cake testCake = createTestCake();
		Cake result = cakeService.save(testCake);
		assertEquals(testCake.getTitle(), result.getTitle());
		assertEquals(testCake.getDescription(), result.getDescription());
		assertEquals(testCake.getImage(), result.getImage());
	}

	@Test
	void whenExistsByTitle_thenReturnFalse() {
		boolean exists = cakeService.existsByTitle("This title does not exist");
		assertFalse(exists);
	}

	@Test
	void whenExistsByTitle_thenReturnTrue() {
		boolean exists = cakeService.existsByTitle(carrotCake.getTitle());
		assertTrue(exists);
	}

	@Test
	void whenFindAll_thenReturnAllCakes() {
		List<Cake> cakes = cakeService.findAll();
		assertTrue(cakes.size() > 0);
	}

	@Test
	void whenFindByIdThatDoesNotExist_thenExceptionRasied() {
		Optional<Cake> cake = cakeService.findById(100L);
		assertFalse(cake.isPresent(), "Should not have found cake id: 100 in the db");
	}

	@Test
	void whenFindByTitle_thenReturnCake() {
		Cake cake = cakeService.findByTitle(carrotCake.getTitle());
		assertEquals(carrotCake.getTitle(), cake.getTitle());
	}

	@Test
	void whenFindByTitleThatDoesNotExist_thenReturnNull() {
		Cake cake = cakeService.findByTitle("Title that does not exist");
		assertNull(cake, "Should not have found cake title: 'Title that does not exist' in the db");
	}

	@Test
	void whenSaveExisitingTitleOfCake_thenExceptionRasied() {
		try {
			cakeService.save(carrotCake);
			fail("Should not have saved the carrot cake as it already exsits in the database");
		} catch (Exception expected) {
			assertTrue(expected.getMessage().contains("could not execute statement"));
		}
	}
}
