public class RomanObserver extends Observer {
    /**
     * Setting the values and the roman symbols. We add 4,9 and the multiples of them because they have no symbols
     * and they are being created by subtraction. These will make the method handle them correctly.
     */
    private String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public RomanObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Roman String: " + (romanBuilder(subject.getState())));
    }

    /**
     * The romanBuilder method loops through each element in the romanValues array, it begins from 1000 as it is the
     * first and greatest element. Then it checks if the parameter is greater than or equal to the element. If it is,
     * the symbol of the element is being added to the result and the parameter is being decremented by the element.
     * This keeps ongoing till the parameter hits 0.
     * @param number is the number that will be converted
     * @return sb.toString() returns the string representation.
     */
    public String romanBuilder(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanValues.length; i++) {
            while(number >= romanValues[i]){
                sb.append(romanSymbols[i]);
                number -= romanValues[i];
            }
        }
        return sb.toString();
    }
}
