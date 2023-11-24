public class Converter {
    int lengthStep = 75;
    int caloriesStep = 50;
    int kmToCm = 100_000;
    int kilcalToCal = 1000;

    int convertToKm(int steps) {
        return steps*lengthStep/kmToCm;
    }

    int convertStepsToKilocalories(int steps) {
    return steps*caloriesStep/kilcalToCal;
    }
}