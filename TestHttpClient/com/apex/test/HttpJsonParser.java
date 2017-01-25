package com.apex.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HttpJsonParser {
  @Test
  public void httpJsonSuccessScenario() {
	
	  
	    String url = "http://www.thomas-bayer.com/sqlrest/PRODUCT/1";

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
				Product product = (Product) jaxbUnmarshaller.unmarshal(
						new StringBufferInputStream(result.toString()));
				//Valid Id Case
				Assert.assertEquals(1, product.getId());
		//ObjectMapper mapper = new ObjectMapper();
		//Product user = new User();
		//User user = mapper.readValue(result, Product.class);
		
		
  }
}
