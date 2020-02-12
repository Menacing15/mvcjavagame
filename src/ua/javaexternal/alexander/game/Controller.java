package ua.javaexternal.alexander.game;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        view.printGreetings();
        model.setPrimaryBarrier(GlobalConstants.MIN_BARRIER,
                GlobalConstants.MAX_BARRIER);
        model.setSecretValue();

        int currentAttemptCount = 1;
        while (!model.checkValue(scanInputIntValue(sc))) {
            if(currentAttemptCount++ == GlobalConstants.ATTEMPTS_COUNT){
                break;
            }
        }
        if(currentAttemptCount > GlobalConstants.ATTEMPTS_COUNT){
            view.printDefeat(model);
        }else {
            view.printCongratulation(model);
        }
        view.printStats(model);
    }

    private int scanInputIntValue(Scanner sc) {
        int result = 0;
        view.print(view.getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));

        while (true) {
            while (!sc.hasNextInt()) {
                view.printInvalidInput(model);
                sc.next();
            }
            if ((result = sc.nextInt()) <= model.getMinBarrier()
                    || result >= model.getMaxBarrier()) {
                view.printInvalidRangeInput(model);
                continue;
            }
            break;
        }
        return result;
    }
}
