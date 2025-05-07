public class Main {
    public static void main(String[] args) {
        int[] sequenciaPaginas = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int quadrosMemoria = 3;

        System.out.println("Resultados para " + quadrosMemoria + " quadros:");
        System.out.println("FIFO: " + FIFO.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("LRU: " + LRU.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("Relógio: " + Clock.calcularFaltas(sequenciaPaginas, quadrosMemoria));
        System.out.println("Envelhecimento: " + Aging.calcularFaltas(sequenciaPaginas, quadrosMemoria));
    }
}