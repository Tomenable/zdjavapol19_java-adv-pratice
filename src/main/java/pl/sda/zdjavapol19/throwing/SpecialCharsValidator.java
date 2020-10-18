package pl.sda.zdjavapol19.throwing;

import org.apache.commons.lang3.ArrayUtils;

public class SpecialCharsValidator extends ContainsCharsValidator {

    static char[] unicodes;

    //33-47; 58-64; 91-96; 123-126
    static {
        char[] specialCharsGroup1 = unicodesToCharsRange(33, 47);
        char[] specialCharsGroup2 = unicodesToCharsRange(58, 64);
        char[] specialCharsGroup3 = unicodesToCharsRange(91, 96);
        char[] specialCharsGroup4 = unicodesToCharsRange(123, 126);

        unicodes = new char[specialCharsGroup1.length + specialCharsGroup2.length + specialCharsGroup3.length + specialCharsGroup4.length];
        unicodes = ArrayUtils.addAll(unicodes, specialCharsGroup1);
        unicodes = ArrayUtils.addAll(unicodes, specialCharsGroup2);
        unicodes = ArrayUtils.addAll(unicodes, specialCharsGroup3);
        unicodes = ArrayUtils.addAll(unicodes, specialCharsGroup4);
    }

    public SpecialCharsValidator() {
        super(unicodes);
    }
}
