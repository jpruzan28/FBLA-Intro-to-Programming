package DrawingSurface;

public class AIQuestionGenerator {
	
	private static final String APIKey = "your-api-key-here";
	private static final String APIURL = "https://api.anthropic.com/v1/messages";
	
	public static String generateQuestion(String topic, String difficulty) {
		String prompt = String.format("Generate a single %s difficulty question about %s. " +
                "Respond in JSON format: " +
                "{\"question\": \"...\", \"options\": [\"A\", \"B\", \"C\", \"D\"], \"answer\": \"A\"}",
                difficulty, topic);
		
		return prompt;
	}

}
