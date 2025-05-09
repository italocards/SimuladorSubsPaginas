import java.util.*;

public class Otimo {
    public static int calcularFaltas(int[] paginas, int quadros) {
        List<Integer> memoria = new ArrayList<>();
        int faltas = 0;

        for (int i = 0; i < paginas.length; i++) {
            int pagina = paginas[i];
            if (!memoria.contains(pagina)) {
                faltas++;

                if (memoria.size() < quadros) {
                    memoria.add(pagina);
                } else {
                    int paginaParaRemover = -1;
                    int maisDistante = -1;

                    for (int p : memoria) {
                        int proximoUso = Integer.MAX_VALUE;
                        for (int j = i + 1; j < paginas.length; j++) {
                            if (paginas[j] == p) {
                                proximoUso = j;
                                break;
                            }
                        }
                        if (proximoUso > maisDistante) {
                            maisDistante = proximoUso;
                            paginaParaRemover = p;
                        }
                    }

                    memoria.remove((Integer) paginaParaRemover);
                    memoria.add(pagina);
                }
            }
        }
        return faltas;
    }
}