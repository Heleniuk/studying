package romantointeger;

import static romantointeger.Configuration.ROMAN_TO_INTEGER_MAPPING;

public class RomanToIntegerConverter {
    public int convert(String romanNumber) {
        Integer directMappingResult = ROMAN_TO_INTEGER_MAPPING.get(romanNumber);
        if (directMappingResult != null) {
            return directMappingResult;
        } else {
            int[] integers = new int[romanNumber.length()];
            for (int i = 0; i < romanNumber.length(); i++) {
                String currentSymbol = Character.toString(romanNumber.charAt(i));
                Integer mappingResult = ROMAN_TO_INTEGER_MAPPING.get(currentSymbol);

                if (mappingResult == null) {
                    String message = "Symbol " + currentSymbol + " does not belong to Roman numbers";
                    throw new IllegalArgumentException(message);
                }
                integers[i] = mappingResult;
            }

            int result = integers[0];
            for (int i = 0; i < integers.length - 1; i++) {
                if (integers[i] >= integers[i + 1]) {
                    result += integers[i + 1];
                } else {
                    int delta = integers[i + 1] - integers[i];
                    if (isValid(delta)) {
                        result += integers[i + 1] - 2 * integers[i];
                    } else {
                        String message = "Input does not belong to Roman numbers";
                        throw new IllegalArgumentException(message);
                    }
                }
            }
            return result;
        }
    }

    private boolean isValid(int delta) {
        return delta == 4 || delta == 9 || delta == 40 || delta == 90
                || delta == 400 || delta == 900;
    }
}
