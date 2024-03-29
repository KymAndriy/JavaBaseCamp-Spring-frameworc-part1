package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess Number");
        // create context
        ApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);

        // get bean
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // biz logic
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose number from 1 to 100");
        int guess = sc.nextInt();
        log.info("My guess = {}",guess);

        // get bean
        Game game = context.getBean(Game.class);

        game.setGuess(guess);
        log.info("Result = {}", game.isGameWon() ? "Win" : "Lose");


    }
}
