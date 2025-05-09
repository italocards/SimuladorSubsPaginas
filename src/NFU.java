import java.util.*;

public class NFU {
    public static int calcularFaltas(int[] paginas, int quadros) {
        List<Integer> memoria = new ArrayList<>();
        Map<Integer, Integer> contadorUso = new HashMap<>();
        int faltas = 0;

        for (int pagina : paginas) {
            // Atualiza contadores
            for (int p : memoria) {
                contadorUso.put(p, contadorUso.getOrDefault(p, 0));
            }

            if (!memoria.contains(pagina)) {
                faltas++;

                if (memoria.size() < quadros) {
                    memoria.add(pagina);
                } else {
                    // Encontra a página menos usada
                    int paginaRemover = memoria.get(0);
                    int menorUso = contadorUso.get(paginaRemover);

                    for (int p : memoria) {
                        if (contadorUso.get(p) < menorUso) {
                            paginaRemover = p;
                            menorUso = contadorUso.get(p);
                        }
                    }

                    memoria.remove((Integer) paginaRemover);
                    contadorUso.remove(paginaRemover);
                    memoria.add(pagina);
                }
            }

            contadorUso.put(pagina, contadorUso.getOrDefault(pagina, 0) + 1);
        }

        return faltas;
    }
}