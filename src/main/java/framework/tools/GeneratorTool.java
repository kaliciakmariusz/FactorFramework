package framework.tools;

import org.apache.commons.lang3.StringUtils;

public class GeneratorTool {

    public static int generateRandomNumber(final int min, final int max) {
        return (int) ((max - min + 1) * Math.random() + min);
    }

    public static String generateRandonStringCharacters(int howManyCharacters) {
        String chars = "ABCDEFG HIJKLMNOP QRSTU VWXYZ aąbcćd eęfghij klłmno ópqrs tuvwxyzźż";
        char[] arrChars = chars.toCharArray();
        StringBuilder stringCharacters = new StringBuilder();
        char randomChar;
        for (int i = 0; i < howManyCharacters; i++) {
            randomChar = arrChars[generateRandomNumber(0, arrChars.length - 1)];
            if (i == 0 || i == howManyCharacters - 1 || (i > 0 && stringCharacters.toString().endsWith(StringUtils.SPACE))) {
                while (randomChar == ' ') {
                    randomChar = arrChars[generateRandomNumber(0, arrChars.length - 1)];
                }
            }
            stringCharacters.append(randomChar);
        }
        return stringCharacters.toString();
    }
}
