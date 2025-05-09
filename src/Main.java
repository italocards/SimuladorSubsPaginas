public class Main {
    public static void main(String[] args) {
        int[] sequenciaPaginas = {1,2,3,1,4,2,5,1,6,2};
        int quadrosMemoria = 3;

        System.out.println("Resultados para " + quadrosMemoria + " quadros:");
        System.out.println("FIFO: " + FIFO.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("LRU: " + LRU.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("Ótimo: " + Otimo.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("NFU: " + NFU.calcularFaltas(sequenciaPaginas, quadrosMemoria));
    }
}