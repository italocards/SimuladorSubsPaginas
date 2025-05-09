import java.util.ArrayList;
import java.util.HashMap;

public class LRU {
    public static int calcularFaltas(int[] paginas, int quadros) {
        ArrayList<Integer> memoria = new ArrayList<>();
        HashMap<Integer, Integer> ultimoAcesso = new HashMap<>();
        int tempo = 0;
        int faltas = 0;

        for (int pagina : paginas) {
            if (!memoria.contains(pagina)) {
                faltas++;

                if (memoria.size() == quadros) {
                    int paginaRemover = memoria.get(0);
                    int menorTempo = ultimoAcesso.get(paginaRemover);

                    for (int p : memoria) {
                        if (ultimoAcesso.get(p) < menorTempo) {
                            paginaRemover = p;
                            menorTempo = ultimoAcesso.get(p);
                        }
                    }

                    memoria.remove((Integer) paginaRemover);
                }

                memoria.add(pagina);
            }

            // Atualiza o tempo de acesso após garantir que a página está na memória
            ultimoAcesso.put(pagina, tempo++);
        }

        return faltas;
    }
}
