/**
 * 
 * Author: Konstantinos Chatzis <kachatzis@ece.auth.gr>
 * 
 * com.geniedev.APIClient
 * 
 */

package com.geniedev.APIClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GETClient extends Client {
	
	public GETClient () { super(); }
	
	
	public void execute() {

		  try {
			  
			String urlFilter = "";
			if (this.filter.length()>0) urlFilter = this.filter;

			URL url = new URL(this.baseUrl + this.modelName + "?filter=" + urlFilter + "&fields=" + fields);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-DreamFactory-API-Key", this.apiKey);
			
			System.out.println( url );
			System.out.println("Filter: " + this.filter);
			//System.out.println("Response: " + conn.getResponseCode());
			
			this.responseCode = conn.getResponseCode();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output, response="";
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				response += output;
			}
			
			response = response.trim();
			response += "{{end}}";
			setData(response);
			dataToObject();
			
			conn.disconnect();
			
			if (DEBUG) System.out.println( response );

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		  
		}

}
