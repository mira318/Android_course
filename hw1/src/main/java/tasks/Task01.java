package tasks;

public class Task01 {

    /**
     * Возвращает минимальное значение из массива.
     * Не использовать стандартную библиотеку!
     */
    public static int min(int[] ints) {
        if(ints.length == 0) {
            throw new IllegalArgumentException("This input array is empty");
        }
        int min = Integer.MAX_VALUE;
        for (int i : ints) {
            if(min > i){
                min = i;
            }
        }
        return min;
    }

    public static float average(int[] ints){
        if(ints.length == 0) {
            throw new IllegalArgumentException("This input array is empty");
        }
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return sum / ((float)ints.length);

    }

}
