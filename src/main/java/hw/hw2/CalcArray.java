package hw.hw2;

public class CalcArray {


    public void validate(String[][] arr, int squareLength) {
        if (arr.length != squareLength) {
            throw new MyArraySizeException("Не та длина");
        }

        for (int i=0; i< arr.length; i++) {
            if (arr[i].length != squareLength) {
                throw new MyArraySizeException("Не та длина");
            }
        }
    }


    private int calculate(String[][] arr) {
        int sum = 0;
        for (int i=0; i < arr.length; i++) {
            for (int j = 0; j< arr[i].length; j++) {
                try {
                    sum +=Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(String.format("В строке %d и столбце %d невалидный символ", i, j));
                }
            }
        }
        return sum;
    }

    public int calculateSquare(String[][] arr, int squareLength) {
        validate(arr, squareLength);
        return calculate(arr);
    }


}
