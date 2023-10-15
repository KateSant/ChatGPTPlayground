package experiments;



public class Main {
    public static void main(String[] args) {

        String questionForHallucinating = "What is a circle?";

        System.out.println("LOW TEMP:");
        new Hallucinate(0.1, questionForHallucinating).chat()
                .forEach(r -> {System.out.println(r.getMessage().getContent());});

        System.out.println("HIGH TEMP:");
        new Hallucinate(0.99, questionForHallucinating).chat()
            .forEach(r -> {System.out.println(r.getMessage().getContent());});

    }
}