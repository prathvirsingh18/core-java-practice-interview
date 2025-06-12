package OOPS.polymorphism;

public class CalculateArea {
    void calculateArea(){
        System.out.println("Calculate Area class");
    }
    int sum(int a, int b){//method overloading compile time poymorphism
    return a+b;
    }

    int sum(int a, int b, int c){
        return a+b+c;
    }
    double divide(int a, int b){
        return b/a;
    }
}
class RectangleArea extends CalculateArea{
    void calculateArea(){// overriding
        System.out.println("rectangle area class");
    }

}
class Circle extends CalculateArea{
    void calculateArea(){
        System.out.println("circle class");
    }
}
class Test{
    public static void main(String[] args) {
        CalculateArea rec = new RectangleArea();
        rec.calculateArea();

        CalculateArea cl = new Circle();
        cl.calculateArea();

    }
}