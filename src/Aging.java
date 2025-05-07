import java.util.ArrayList;
import java.util.HashMap;

public class Aging {
    public static int calcularFaltas(int[] paginas, int quadros) {
        ArrayList<Integer> memoria = new ArrayList<>();
        HashMap<Integer, Integer> contadorEnvelhecimento = new HashMap<>();
        int faltas = 0;

        for (int pagina : paginas) {
            for (int p : memoria) {
                contadorEnvelhecimento.put(p, contadorEnvelhecimento.get(p) >>> 1);
            }

            if (!memoria.contains(pagina)) {
                faltas++;

                if (memoria.size() >= quadros) {
                    // encontra pagina menor contador
                    int paginaRemover = memoria.get(0);
                    int menorContador = contadorEnvelhecimento.get(paginaRemover);

                    for (int p : memoria) {
                        if (contadorEnvelhecimento.get(p) < menorContador) {
                            paginaRemover = p;
                            menorContador = contadorEnvelhecimento.get(p);
                        }
                    }

                    memoria.remove((Integer) paginaRemover);
                    contadorEnvelhecimento.remove(paginaRemover);
                }

                memoria.add(pagina);
                contadorEnvelhecimento.put(pagina, 0);
            }

            contadorEnvelhecimento.put(pagina, contadorEnvelhecimento.get(pagina) | 0x80);
        }
        return faltas;
    }
}