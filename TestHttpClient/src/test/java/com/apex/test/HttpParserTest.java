package com.apex.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class HttpParserTest {
	
  @Test
  public void testHttpParserScenario() throws ClientProtocolException, IOException, JAXBException {
	    String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/1";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		//request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		} 
		
		//File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		@SuppressWarnings("deprecation")
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(
				new StringBufferInputStream(result.toString()));
		//Valid Id Case
		Assert.assertEquals(1, customer.getId());
		
		//Invalid Id
		//Assert.assertEquals(10, customer.getId());
		//Blank Id
		
		//Assert.assertEquals(0, customer.getId());
		
		
		//Wrong DataType
		System.out.println(customer.getCity());
		//System.out.println(customer.toString());

		
  }
}
