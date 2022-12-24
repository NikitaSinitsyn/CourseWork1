public class Validator {
    public static boolean isNumberIsInInterval(double number, double lowerBound, double upperBound){
        boolean isNumberInInterval = lowerBound <= number && number <= upperBound;
        return isNumberInInterval;
    }
    public static boolean isNumberIsInInterval(int number, int lowerBound, int upperBound){
        boolean isNumberInInterval = lowerBound <= number && number <= upperBound;
        return isNumberInInterval;
    }
}
