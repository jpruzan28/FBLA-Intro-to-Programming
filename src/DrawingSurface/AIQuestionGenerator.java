package DrawingSurface;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import org.json.JSONObject;

import java.util.Properties;
import java.io.FileInputStream;

public class AIQuestionGenerator {
	
	private static final String APIKEY = loadApiKey();

	public static String loadApiKey() {
	    try {
	        Properties props = new Properties();
//	        String path = System.getProperty("user.home") + "/Documents/GitHub/FBLA-Intro-to-Programming/src/DrawingSurface/config.properties";
	        
	        String epath = "C:/Users/nekoa/OneDrive/Documents/GitHub/FBLA-Intro-to-Programming/src/DrawingSurface/config.properties";
	        String jpath = "C:/Users/jasmi/Documents/GitHub/FBLA-Intro-to-Programming/src/DrawingSurface/config.properties";
	        
	        props.load(new FileInputStream(epath));	       

	        return props.getProperty("APIKEY");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	private static final String APIURL = "https://api.anthropic.com/v1/messages";
	
	public static String generateQuestion(String topic, String difficulty) {
		String prompt = String.format(
			    "Generate a single %s difficulty multiple choice question about %s. " +
			    "Reply with only a JSON object containing these exact fields: question, options, answer. " +
			    "options must be an array of exactly 4 strings. answer must be the correct option text.",
			    difficulty, topic
			);
		
		String escapedPrompt = prompt.replace("\"", "\\\"");

		String requestBody = "{"
		    + "\"model\": \"claude-opus-4-6\","
		    + "\"max_tokens\": 1024,"
		    + "\"messages\": ["
		    + "  {"
		    + "    \"role\": \"user\","
		    + "    \"content\": \"" + escapedPrompt + "\""
		    + "  }"
		    + "]"
		    + "}";
		
		HttpClient client = HttpClient.newHttpClient();
		

		HttpRequest request = HttpRequest.newBuilder()
		    .uri(URI.create(APIURL))
		    .header("Content-Type", "application/json")
		    .header("x-api-key", APIKEY)
		    .header("anthropic-version", "2023-06-01")
		    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
		    .build();

		try {
		    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		    String responseBody = response.body();

		    JSONObject json = new JSONObject(responseBody);
		    
		    System.out.println(responseBody);

		    
		    String text = json.getJSONArray("content").getJSONObject(0).getString("text");
		    text = text.replace("```json", "").replace("```", "").trim();
		    System.out.println(text);
		    return text;
		    
		} catch (Exception e) {
		   // e.printStackTrace();
			 return "{\"question\": \"What is the best way to build an emergency fund?\", " +
	           "\"options\": [" +
	           "\"Invest all your money in stocks\", " +
	           "\"Save 3-6 months of expenses in a separate account\", " +
	           "\"Spend your extra money on things you enjoy\", " +
	           "\"Lend money to friends and family\"], " +
	           "\"answer\": \"Save 3-6 months of expenses in a separate account\"}";

		}		
	}
	
}
