public class Modul1 { 
    /** * @param args the command line arguments */ 
    public static void main(String[] args) {
        Modul1 m=new Modul1();
        int num1=m.introduir();
        int num2=m.introduir();
        int g=m.calcularGran(num1, num2);
        m.imprimir(g); 
    }
    public int introduir() {
        Scanner teclat=new Scanner(System.in);
        System.out.println("Valor:");
        int n=teclat.nextInt();
        return n;
    } 
    public int calcularGran(int n1,int n2){
        int gran=0;
        if (n1>=n2){
           gran=n1;
        }else{ 
           gran=n2; 
        } 
        return gran; 
    } 
    public void imprimir(int n){
        System.out.println("Gran:"+n); 
    }
}