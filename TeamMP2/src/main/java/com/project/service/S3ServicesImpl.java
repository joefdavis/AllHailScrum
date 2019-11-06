package com.project.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class S3ServicesImpl implements S3Services {

	@Autowired
	private AmazonS3 s3client;

	private String bucketName = "mothra.co";

	@Override
	public ByteArrayOutputStream downloadFile(String keyName) {
		try {
			S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));

			InputStream is = s3object.getObjectContent();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len;
			byte[] buffer = new byte[4096];
			while ((len = is.read(buffer, 0, buffer.length)) != -1) {
				baos.write(buffer, 0, len);
			}

			return baos;
		} catch (IOException ioe) {
		} catch (AmazonServiceException ase) {
			throw ase;
		} catch (AmazonClientException ace) {
			throw ace;
		}

		return null;
	}

	@Override
	public void uploadFile(String keyName, MultipartFile file) {
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			s3client.putObject(bucketName, keyName, file.getInputStream(), metadata);
		} catch (IOException ioe) {
		} catch (AmazonServiceException ase) {
			throw ase;
		} catch (AmazonClientException ace) {
			throw ace;
		}
	}

	public List<String> listFiles() {

		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName);
		// .withPrefix("test" + "/");

		List<String> keys = new ArrayList<>();

		ObjectListing objects = s3client.listObjects(listObjectsRequest);

		while (true) {
			List<S3ObjectSummary> summaries = objects.getObjectSummaries();
			if (summaries.size() < 1) {
				break;
			}

			for (S3ObjectSummary item : summaries) {
				if (!item.getKey().endsWith("/"))
					keys.add(item.getKey());
			}

			objects = s3client.listNextBatchOfObjects(objects);
		}

		return keys;
	}
}