import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Homework10 {

    @Test
    public void lengthTest() {
        String[] word = {"truetruetruetruetrue", "123456789asdfgh", "false"};

        for (int i = 0; i < word.length; i++) {
            int x = word[i].length();
            System.out.println(word[i] + " = " + x);
            assertTrue(x>=15, "String length greater than 15");
        }
    }
}
