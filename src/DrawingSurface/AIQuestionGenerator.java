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
	        
	        props.load(new FileInputStream(jpath));	       

	        return props.getProperty("APIKEY");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	private static final String APIURL = "https://api.anthropic.com/v1/messages";
	
	public static String generateQuestion(String topic, String difficulty) {
	    String prompt = String.format(
	        "Generate a single multiple choice question about %s for children ages 5 to 11. " +
	        "Make it %s difficulty within that age range. " +
	        "Use simple, friendly words and short sentences a young child can read. " +
	        "Use everyday examples kids relate to (allowance, toys, snacks, sharing, " +
	        "saving up for something they want). " +
	        "Avoid jargon, big numbers, complex math, and any scary or upsetting topics. " +
	        "Keep a warm, encouraging tone. " +
	        "Reply with ONLY a JSON object containing these exact fields: question, options, answer. " +
	        "options must be an array of exactly 4 short strings. " +
	        "answer must exactly match one of the option strings.",
	        topic, difficulty
	    );

	    String escapedPrompt = prompt.replace("\"", "\\\"");
	    // ... rest stays the same
	

		String requestBody = "{"
		    + "\"model\": \"claude-sonnet-4-6\","
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
		    
		    
		    String text = json.getJSONArray("content").getJSONObject(0).getString("text");
		    text = text.replace("```json", "").replace("```", "").trim();
		    return text;
		    
		} catch (Exception e) {
		    //e.printStackTrace();
			return "{\"question\": \"You want to buy a toy that costs $10, but you only have $4. What is a good thing to do?\", " +
		       "\"options\": [" +
		       "\"Take the toy without paying\", " +
		       "\"Save a little money each week until you have enough\", " +
		       "\"Forget about it and feel sad\", " +
		       "\"Ask a stranger to buy it for you\"], " +
		       "\"answer\": \"Save a little money each week until you have enough\"}";
		}		
	}
	
}
