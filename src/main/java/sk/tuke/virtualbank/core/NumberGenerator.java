package sk.tuke.virtualbank.core;

import java.util.Random;

public class NumberGenerator {

    public String generateCardNumber() {
        Random random = new Random();
        return "SK" + random.nextInt(1000000) + "000000" + random.nextInt(1000000000) + random.nextInt(10);
    }

    public String generateEmailCode() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000));
    }


}
