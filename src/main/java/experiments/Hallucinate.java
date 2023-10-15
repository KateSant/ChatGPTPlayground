package experiments;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public class Hallucinate {

    private double temperature;
    private String question;
    private static String SYSTEM_PROMPT = "You are a crazy chat bot";

    public Hallucinate(double temperature, String question){

        this.temperature = temperature;
        this.question = question;
    }

    public List<ChatCompletionChoice> chat(){

        String key = System.getenv("OPENAI_KEY");
        OpenAiService openAiService = new OpenAiService(key, Duration.ofSeconds(20));
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .temperature(temperature)
                .messages(
                        List.of(
                                new ChatMessage("system", SYSTEM_PROMPT),
                                new ChatMessage("user", question)))
                .build();


        return openAiService.createChatCompletion(chatCompletionRequest)
                .getChoices();
    }
}
