package guru.qa;

public class Main {

    public static void main(String[] args) {

        int a = 5;
        int b = 10;
        int c = 20;
        int d = 40;
        boolean e = true;
        boolean f = false;
        int g = Integer.MAX_VALUE;
        double h = 5.1;

//        Арифметические операторы

        System.out.println(a + b + c + d);
        System.out.println(a - b - c - d);
        System.out.println((a * b) * (c * d));
        System.out.println((b / a) * (d / c));
        System.out.println(a + b + c + d);
        System.out.println(a % b * (c + d));
        System.out.println("a++:" + a++);
        System.out.println("a--:" + a--);

//        Операторы сравнения

        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

//        Логические операторы

        System.out.println("e && f = " + (e&&f));
        System.out.println("e || f = " + (e||f) );
        System.out.println("!(e && f) = " + !(e && f));

//        Пример переполнения

        System.out.println(g + 1);

//        Вычисления комбинаций типов данных (int и double)\

        System.out.println(a + h);

    }
}