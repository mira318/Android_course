package tasks;

import org.junit.Assert;
import org.junit.Test;

public class Task04Test {

    double delta = 0.000000001;

    @Test
    public void length_test(){
        Vector A = new Vector(1, 2, 2);
        Vector B = new Vector(2, 3, 6);

        Assert.assertEquals(3, A.get_length(), delta);
        Assert.assertEquals(7, B.get_length(), delta);
    }

    @Test
    public void test_scalar_prod(){
        Vector A = new Vector(1.5, 2.1, 3.2);
        Vector B = new Vector(0.5, 3.6, 4.0);
        Vector C = new Vector(1.1, 2.3, 2.2);

        Assert.assertEquals(21.11, A.scalar_product(B), delta);
        Assert.assertEquals(17.63, B.scalar_product(C), delta);
    }

    @Test
    public void test_cross_prod(){
        Vector A = new Vector(1.5, 2.1, 3.2);
        Vector B = new Vector(0.5, 3.6, 4.0);
        Vector C = new Vector(1.1, 2.3, 2.2);

        Vector D = new Vector(-3.12, -4.4, 4.35);
        Vector E = new Vector(-1.28, 3.3, -2.81);
        Assert.assertEquals(D, A.cross_product(B));
        Assert.assertEquals(E, B.cross_product(C));
    }

    @Test
    public void test_cos(){
        Vector A = new Vector(1, 2, 2);
        Vector B = new Vector(0.5, 1, 1);
        Vector C = new Vector(1, -0.5, 0);
        Assert.assertEquals(1, A.get_cos(B), 0.000000001);
        Assert.assertEquals(0, B.get_cos(C), 0.000000001);
    }

    @Test
    public void test_sum_diff(){
        Vector A = new Vector(1, 2, 3);
        Vector B = new Vector(3, 4, 3);
        Vector C = new Vector(8, 1, 3);

        Vector AB_sum = new Vector(4, 6, 6);
        Vector BC_sum = new Vector(11, 5, 6);

        Vector AB_diff = new Vector(-2, -2, 0);
        Vector BC_diff = new Vector(-5, 3, 0);
        Vector BA_diff = new Vector(2, 2, 0);
        Vector CA_diff = new Vector(7, -1, 0);

        Assert.assertEquals(AB_sum, A.sum(B));
        Assert.assertEquals(BC_sum, B.sum(C));

        Assert.assertEquals(AB_diff, A.diff(B));
        Assert.assertEquals(BC_diff, B.diff(C));
        Assert.assertEquals(BA_diff, B.diff(A));
        Assert.assertEquals(CA_diff, C.diff(A));

    }
}
