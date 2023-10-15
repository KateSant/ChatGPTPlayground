package experiments;



public class Main {
    public static void main(String[] args) {

        System.out.println("LOW TEMP:");
        new ChatWithTemperature(0.1).chat()
                .forEach(choice -> {System.out.println(choice.getMessage().getContent());});

        System.out.println("HIGH TEMP:");
        new ChatWithTemperature(2).chat()
            .forEach(choice -> {System.out.println(choice.getMessage().getContent());});

    }
}