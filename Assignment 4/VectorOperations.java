import java.util.Scanner;

public class VectorOperations {
    public static void main(String[] args) {
   
        try {
            double[] v1 = {1, 2};
            double[] v2 = {2, 3};
            double[] v3 = {1, 2, 3};
            double[] v4 = {2, 3, 4};
            //double[] v5 = {1, 2, 3, 4};
            double[] v6 = {1, 2, 3};
            double[] v7 = {4, 5};
            


            Vector vector1 = new Vector(v1);
            Vector vector2 = new Vector(v2);
            Vector vector3 = new Vector(v3);
            Vector vector4 = new Vector(v4);
            //Vector vector5 = new Vector(v5);
            Vector vector6 = new Vector(v6);
            Vector vector7 = new Vector(v7);
            Vector sum_2D = vector1.add(vector2);
            Vector diff_2D = vector1.subtract(vector2);
            double dot_2D = vector1.dot(vector2);

            Vector sum_3D = vector3.add(vector4);
            Vector diff_3D = vector3.subtract(vector4);
            double dot_3D = vector3.dot(vector4);


            Vector sum_Exp = vector6.add(vector7);

            System.out.println("v1: " + vector1);
            System.out.println("v2: " + vector2);
            System.out.println("v3: " + vector3);
            System.out.println("v4: " + vector4);
            System.out.println("Addition (2D): " + sum_2D);
            System.out.println("Subtraction (2D): " + diff_2D);
            System.out.println("Dot Product (2D): " + dot_2D);
            System.out.println("Addition (3D): " + sum_3D);
            System.out.println("Subtraction (3D): " + diff_3D);
            System.out.println("Dot Product (3D): " + dot_3D);
        } catch (VectorException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
    }
}
}