package tasks;

import java.util.Random;

/**
 * Напишите класс, конструктор которого принимает два массива:
 * массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент
 * из первого массива случайным образом, с учётом его веса.
 * Пример:
 * Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже,
 * чем значение «2» и в десять раз реже, чем значение «3».
 */
class RandomFromArray {
    int[] values;
    int[] weights;
    int size;
    int[] prefix_sum;
    Random generator;

    RandomFromArray(int[] val, int[] wei){
        values = new int[val.length];
        weights = new int[wei.length];
        size = weights.length;

        for(int i = 0; i < val.length; ++i){
            values[i] = val[i];
            weights[i] = wei[i];
        }

        prefix_sum = new int[values.length];
        prefix_sum[0] = weights[0];
        for(int i = 1; i < size; ++i){
            prefix_sum[i] = prefix_sum[i - 1] + weights[i];
        }

        generator = new Random();
    }
    // Использовать random generator.

    int get_el(){
        int rand = generator.nextInt(prefix_sum[size - 1]);
        //System.out.println(rand);
        if(rand <= prefix_sum[0]) {
            return values[0];
        }
        for(int i = 0; i < size - 1; ++i){
            if((rand > prefix_sum[i]) && (rand <= prefix_sum[i + 1])){
                return values[i + 1];
            }
        }
        throw new RuntimeException("To big rand");
    }
}

public class Task05 {
    public static void main(String[] args) {
        int[] a = {1, 9};
        int[] b = {2, 3};
        int n = 10;
        RandomFromArray gen = new RandomFromArray(a, b);
        for(int i = 0; i < n; ++i){
            System.out.print(gen.get_el() + " ");
        }
        System.out.println("");

        int[] c = {1, 3, 5};
        int[] d = {1, 2, 10};
        int m = 15;
        RandomFromArray gen2 = new RandomFromArray(c, d);
        for(int i = 0; i < m; ++i){
            System.out.print(gen2.get_el() + " ");
        }
    }
}
