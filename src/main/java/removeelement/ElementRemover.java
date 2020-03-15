package removeelement;

public class ElementRemover {
    public int removeElement(int[] input, int elementToRemove) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < input.length - count; i++) {
            if (input[i] == elementToRemove) {
                count++;
                while (count + i < input.length && input[input.length - count] == elementToRemove) {
                    count++;
                }
                input[i] = input[input.length - count];
                input[input.length - count] = elementToRemove + 1;
            }
        }
        return input.length - count;
    }
}
