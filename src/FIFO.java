import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class FIFO {

    public static int calcularFaltas(int[] paginas, int quadros) {
        Queue<Integer> fila = new LinkedList<>();
        HashMap<Integer, Boolean> naMemoria = new HashMap<>();
        int faltas = 0;

        for (int pagina : paginas) {
            if (!naMemoria.containsKey(pagina) || !naMemoria.get(pagina)) {
                faltas++;

                //mem cheia, remove mais antiga
                if (fila.size() == quadros) {
                    int paginaRemovida = fila.poll();
                    naMemoria.put(paginaRemovida, false);
                }

                fila.add(pagina);
                naMemoria.put(pagina, true);
            }
        }

        return faltas;
    }
}