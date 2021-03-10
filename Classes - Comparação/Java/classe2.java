public class CircleApp {
     public static void main (String[] args){
          Circle c = new Circle("opcao 2", "quadriculado");
          c.print();
     }
}

class Circle{
     String traco;
     String extremidade;
     Circle(String traco, String extremidade){
           this.traco = traco;
           this.extremidade = extremidade;
     }
     void print(){
         System.out.format("Circulo possui o estilo de contorno a %s e sua extremidade eh %s", this.traco, this.extremidade);
     }
}
