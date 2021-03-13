public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(50,25);
        int a = r1.area();
        System.out.println(a);
    }
}
class Rect {
    int x, y;
    Rect (int x, int y) {
        this.x = x;
        this.y = y;
    }
    int area(){
       return this.x * this.y;
    }
    
}
