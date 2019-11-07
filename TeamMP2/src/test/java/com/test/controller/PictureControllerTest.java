package com.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.controller.PictureController;

public class PictureControllerTest {
	PictureController pc = new PictureController();
	
	@Test
	public void existance() {
		assertNotNull(pc);
	}

	@Test
	public void nameGenerator() {
		assertEquals(20, pc.postPicNameGenerator().length());
	}
	
	

}
