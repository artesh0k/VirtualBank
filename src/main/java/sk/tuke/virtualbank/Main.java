package sk.tuke.virtualbank;

import sk.tuke.virtualbank.core.Accountlol;
import sk.tuke.virtualbank.core.NumberGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        NumberGenerator numberGenerator = new NumberGenerator();
        System.out.println(numberGenerator.generateIBAN());
        System.out.println(numberGenerator.generateEmailCode());

        Accountlol account = new Accountlol(numberGenerator.generateIBAN(), 1000000.0);
        System.out.println(account.Pay(10000));
        System.out.println(account.getMoney());


    }
}