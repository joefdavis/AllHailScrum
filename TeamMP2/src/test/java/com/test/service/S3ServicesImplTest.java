package com.test.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.service.S3ServicesImpl;

public class S3ServicesImplTest {
	S3ServicesImpl s3 = new S3ServicesImpl();

	@Test
	public void exists() {
		assertNotNull(s3);
	}
	@Test
	public void download() {
		assertNotNull(s3.downloadFile("name.jpeg"));
	}

}