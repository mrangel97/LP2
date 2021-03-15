public class CircleApp {
     public static void main (String[] args){
          Circle c = new Circle(27.5, 33.6);
          c.print();
     }
}

class Circle{
     double rx, ry;
     Circle(double rx, double ry){
           this.rx = rx;
           this.ry = ry;
     }
}
