package experiments;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

public class ChatWithTemperature {

    private double temperature;
    private static String SYSTEM_PROMPT = "You are a chat bot";
    private static String USER_PROMPT = "Generate a tag line for an ice cream shop";
    public ChatWithTemperature(double temperature){
        this.temperature = temperature;
    }

    public List<ChatCompletionChoice> chat(){

        String key = System.getenv("OPENAI_KEY");
        OpenAiService openAiService = new OpenAiService(key);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .temperature(temperature)
                .messages(
                        List.of(
                                new ChatMessage("system", SYSTEM_PROMPT),
                                new ChatMessage("user", USER_PROMPT)))
                .build();


        return openAiService.createChatCompletion(chatCompletionRequest)
                .getChoices();
    }
}
