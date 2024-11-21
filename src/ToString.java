// Base class
class Question {
    private String text;

    public Question(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Question: " + text;
    }
}

// Subclass
class ChoiceQuestion extends Question {
    private List<String> choices;

    public ChoiceQuestion(String text) {
        super(text);
        this.choices = new ArrayList<>();
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    public List<String> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nChoices:");
        for (int i = 0; i < choices.size(); i++) {
            sb.append("\n").append(i + 1).append(". ").append(choices.get(i));
        }
        return sb.toString();
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        Question q1 = new Question("What is the capital of France?");
        System.out.println(q1);

        ChoiceQuestion q2 = new ChoiceQuestion("What is 2 + 2?");
        q2.addChoice("3");
        q2.addChoice("4");
        q2.addChoice("5");
        System.out.println(q2);
    }
}
