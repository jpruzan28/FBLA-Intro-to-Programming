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
        props.load(new FileInputStream("config.properties"));
        return props.getProperty("API_KEY");
    	} 
    catch (Exception e) {
        e.printStackTrace();
        return null;
    	}
    }

	private static final String APIURL = "https://api.anthropic.com/v1/messages";
	
	public static String generateQuestion(String topic, String difficulty) {
		String prompt = String.format(
			    "Generate a single %s difficulty question about %s. " +
			    "Respond in JSON format with fields: question (string), options (array of 4 strings), answer (string with the correct option).",
			    difficulty, topic
			);
		
		String requestBody = "{"
			    + "\"model\": \"claude-opus-4-6\","
			    + "\"max_tokens\": 1024,"
			    + "\"messages\": ["
			    + "  {"
			    + "    \"role\": \"user\","
			    + "    \"content\": \"" + prompt + "\""
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
		    return text;
		    
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}		
	}
	
	public static void main(String[] args) {
	    String result = generateQuestion("financial responsibility", "easy");
	    System.out.println(result);
	}

}
