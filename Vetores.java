import java.util.Random;

public class Vetores {
    public static int buscarRepetido(int[] v, int x) {
        for (int i = 0; i < v.length; i += 1) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random gerador = new Random();

        int[] v = new int[1000];
        
        for (int i = 0; i < 1000; i++) {
            v[i] = gerador.nextInt(1000) + 1;
            int resultado = buscarRepetido(v, v[i]);
            System.out.println(resultado);
        }
    }
}