public class Validator {
    public static boolean isNumberIsInInterval(float number, int lowerBound, int upperBound){
        boolean isNumberInInterval = lowerBound <= number && number <= upperBound;
        return isNumberInInterval;
    }
}
