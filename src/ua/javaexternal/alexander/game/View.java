package ua.javaexternal.alexander.game;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static String MESSAGES_BUNDLE_NAME = "property/text";
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            new Locale("ru"));

    private static final String SPACE_SIGN = " ";
    private static final String SEMICOLON_SIGN = ";";
    private static final String OPENS_SQUARE_BRACKET = "[";
    private static final String CLOSING_SQUARE_BRACKET = "]";
    private static final String NEXT_LINE = "\n";

    private static final String INPUT_INT_DATA_KEY = "input.int.data";
    private static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
    private static final String WRONG_RANGE_DATA = "input.wrong.range";
    private static final String GREETINGS = "input.greetings";
    private static final String CONGRATULATION = "input.congratulation";
    private static final String DEFEAT = "input.defeat";
    private static final String YOUR_ATTEMPTS = "input.attempts";
    private static final String YOUR_LOG = "input.log";

    public void print(String message) {
        System.out.println(message);
    }

    private String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String string : message) {
            concatString.append(string);
        }
        return new String(concatString);
    }

    void printGreetings(){
        print(bundle.getString(GREETINGS));
    }

    String getInputMessage(int minBarrier, int maxBarrier) {
        return concatenationString(bundle.getString(INPUT_INT_DATA_KEY),
                SPACE_SIGN, OPENS_SQUARE_BRACKET,
                String.valueOf(minBarrier), SEMICOLON_SIGN,
                String.valueOf(maxBarrier), CLOSING_SQUARE_BRACKET,
                SPACE_SIGN);
    }

    void printInvalidRangeInput(Model model) {
        print(bundle.getString(WRONG_RANGE_DATA) + NEXT_LINE +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    void printInvalidInput(Model model) {
        print(bundle.getString(WRONG_INPUT_INT_DATA) + NEXT_LINE +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    void printCongratulation(Model model) {
        print(bundle.getString(CONGRATULATION) + SPACE_SIGN +
                model.getSecretValue());
    }

    void printDefeat(Model model) {
        print(bundle.getString(DEFEAT) + SPACE_SIGN +
                model.getSecretValue());
    }

    void printStats(Model model) {
        print(bundle.getString(YOUR_LOG) + SPACE_SIGN + model.getLog() + NEXT_LINE +
                bundle.getString(YOUR_ATTEMPTS) + SPACE_SIGN + model.getAttemptsCount());
    }
}
