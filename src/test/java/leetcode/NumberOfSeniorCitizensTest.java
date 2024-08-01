package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfSeniorCitizensTest {

    @Test
    void countSeniors() {
        NumberOfSeniorCitizens system = new NumberOfSeniorCitizens();
        int ans1 = system.countSeniors(new String[]{
                "7868190130M7522", "5303914400F9211", "9273338290F4010"
        });
        assertEquals(2, ans1);
    }
}