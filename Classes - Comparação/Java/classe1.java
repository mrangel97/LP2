public class CircleApp {
     public static void main (String[] args){
          Circle c = new Circle("opcao 2", "quadriculado");
     }
}

class Circle{
     String traco;
     String extremidade;
     Circle(String traco, String extremidade){
           this.traco = traco;
           this.extremidade = extremidade;
     }
}
