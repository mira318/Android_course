package tasks;

import java.util.Objects;
import java.util.Random;

/**
 * Реализовать трехмерный вектор.
 * Условие: https://habr.com/ru/post/440436/#20
 * Там есть решение. Сначала попробуйте самостоятельно.
 */
class Vector {
    private double x;
    private double y;
    private double z;

    Vector(double x_in, double y_in, double z_in){
        x = x_in;
        y = y_in;
        z = z_in;
    }

    double get_length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    double scalar_product(Vector b){
        return x * b.x + y * b.y + z * b.z;
    }

    Vector cross_product(Vector b){
        return new Vector(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x );
    }

    double get_cos(Vector b){
        return scalar_product(b) / get_length() / b.get_length();
    }

    Vector sum(Vector b){
        return new Vector(x + b.x, y + b.y, z + b.z);
    }

    Vector diff(Vector b){
        return new Vector(x - b.x, y - b.y, z - b.z);
    }

    static Vector[] get_random_vectors(int N){
        Random r = new Random();

        Vector[] res = new Vector[N];
        for(int i = 0; i < N; ++i){
            res[i] = new Vector(r.nextDouble(), r.nextDouble(), r.nextDouble());
        }
        return res;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        double delta = 0.000000001;
        return (Math.abs(x - vector.x) < delta) &&
                (Math.abs(y - vector.y) < delta) &&
                (Math.abs(z - vector.z) < delta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

public class Task04 {
    public static void main(String[] args) {
        Vector A = new Vector(1, 2, 2);
        Vector B = new Vector(2, 3, 6);
        System.out.println(A.sum(B));
        System.out.println(A.diff(B));
        System.out.println(A.get_length());
        System.out.println(A.scalar_product(B));
        System.out.println(A.cross_product(B));

        int N = 10;
        Vector[] gen_res = Vector.get_random_vectors(N);
        for(int i = 0; i < N; ++i){
            System.out.println(gen_res[i]);
        }
    }
}
