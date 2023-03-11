public class Questao2 {
    public static void fibonacci(int n){
        int antecessor1 = 0;
        int antecessor2 = 1;
        int proximo=0;
        if (n == antecessor1 || n ==antecessor2){
            System.out.println("Esse número pertence a sequência de Fibonacci");
        }else{
            while (true){
                proximo=antecessor1+antecessor2;
                antecessor1=antecessor2;
                antecessor2=proximo;
                if(proximo==n){
                    System.out.println("Esse número pertence a sequência de Fibonacci");
                    break;
                }
                if (proximo>n){
                    System.out.println("Esse número NÃO pertence a sequência de Fibonacci");
                    break;
                }
            }
        }
    }
}
