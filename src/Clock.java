import java.util.ArrayList;
import java.util.HashMap;

public class Clock {
    public static int calcularFaltas(int[] paginas, int quadros) {
        ArrayList<Integer> memoria = new ArrayList<>();
        HashMap<Integer, Boolean> bitReferencia = new HashMap<>();
        int ponteiro = 0; // Ponteiro do relógio
        int faltas = 0;

        for (int pagina : paginas) {
            if (!memoria.contains(pagina)) {
                faltas++;

                if (memoria.size() >= quadros) {
                    // procura pagina bit de referencia 0
                    while (true) {
                        int paginaAtual = memoria.get(ponteiro);

                        if (bitReferencia.get(paginaAtual)) {
                            // Dá segunda chance e zera o bit
                            bitReferencia.put(paginaAtual, false);
                            ponteiro = (ponteiro + 1) % quadros;
                        } else {
                            // Substitui esta página
                            memoria.set(ponteiro, pagina);
                            bitReferencia.put(pagina, true);
                            ponteiro = (ponteiro + 1) % quadros;
                            break;
                        }
                    }
                } else {
                    // tem espaço na memoria
                    memoria.add(pagina);
                    bitReferencia.put(pagina, true);
                }
            } else {
                // pagina ja na memória, atualiza bit de referencia
                bitReferencia.put(pagina, true);
            }
        }
        return faltas;
    }
}