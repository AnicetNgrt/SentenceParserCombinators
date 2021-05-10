import core.ParseException;
import core.ParseResult;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sentence parser");
        System.out.println("A sentence is one or more words, all separated by one or more spaces, but with no extra spaces at the end.");
        System.out.println("Parser implemented with parser combinators in Java 8.");
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("\n>>> ");
                ParseResult<List<String>> words = (new SentenceParser()).parse(sc.nextLine());
                System.out.println("This is a correct sentence");
                System.out.print("Words found: [ ");
                for(String word: words.output) {
                    System.out.print("\"" + word + "\"");
                    System.out.print(" ");
                }
                System.out.println("]");
            } catch(ParseException e) {
                System.out.println("ERROR!");
                System.out.print(e.failurePoint);
                System.out.println(e.getMessage());
            }
        }
    }
}
