package com.HCLProject.Aladino;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Repo.BoxesRepo;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BoxesServiceTest {

	@Autowired
	private BoxesRepo boxesRepo;

	@Test
	public void testAddBox() {
		Boxes box = new Boxes();
		box.setDimension("10x10x10");
		// box.setpositionsPoints("A1");
		box.setWeight("10kg");
		box.setName("Test Box");

		Boxes addedBox = boxesRepo.save(box);

		assertNotNull(addedBox);
		assertEquals(box.getDimension(), addedBox.getDimension());
		//assertEquals(box.getpositionsPoints(), addedBox.getpositionsPoints());
		assertEquals(box.getWeight(), addedBox.getWeight());
		assertEquals(box.getName(), addedBox.getName());
	}

	@Test
	public void testFindBoxById() {
		Boxes box = new Boxes();
		box.setDimension("10x10x10");
		// box.setpositionsPoints("A1");
		box.setWeight("10kg");
		box.setName("Test Box");

		Boxes addedBox = boxesRepo.save(box);

		Boxes foundBox = boxesRepo.findById(addedBox.getId()).orElse(null);

		assertNotNull(foundBox);
		assertEquals(addedBox.getId(), foundBox.getId());
		assertEquals(addedBox.getDimension(), foundBox.getDimension());
		//assertEquals(addedBox.getpositionsPoints(), foundBox.getpositionsPoints());
		assertEquals(addedBox.getWeight(), foundBox.getWeight());
		assertEquals(addedBox.getName(), foundBox.getName());
	}

	@Test
	public void testUpdateBoxes() {
		Boxes box = new Boxes();
		box.setDimension("10x20x30");
		// box.setpositionsPoints("A1");
		box.setWeight("10kg");
		box.setName("Box1");

		boxesRepo.save(box);

		Boxes updatedBox = boxesRepo.findById(box.getId()).orElseThrow(() -> new RuntimeException("Box not found"));
		updatedBox.setDimension("20x30x40");
		// updatedBox.setpositionsPoints("B1");
		updatedBox.setWeight("20kg");
		updatedBox.setName("Box2");

		boxesRepo.save(updatedBox);

		Boxes foundBox = boxesRepo.findById(box.getId()).orElseThrow(() -> new RuntimeException("Box not found"));
		assertThat(foundBox.getDimension()).isEqualTo("20x30x40");
	//	assertThat(foundBox.getpositionsPoints()).isEqualTo("B1");
		assertThat(foundBox.getWeight()).isEqualTo("20kg");
		assertThat(foundBox.getName()).isEqualTo("Box2");
	}

	@Test
	public void testDeleteBoxes() {
		Boxes box = new Boxes();
		box.setDimension("10x20x30");
		// box.setpositionsPoints("A1");
		box.setWeight("10kg");
		box.setName("Box1");

		boxesRepo.save(box);

		Boxes foundBox = boxesRepo.findById(box.getId()).orElseThrow(() -> new RuntimeException("Box not found"));
		assertThat(foundBox.getDimension()).isEqualTo("10x20x30");

		boxesRepo.delete(foundBox);

		assertThrows(RuntimeException.class, () -> {
			boxesRepo.findById(foundBox.getId()).orElseThrow(() -> new RuntimeException("Box not found"));
		});
	}

}
