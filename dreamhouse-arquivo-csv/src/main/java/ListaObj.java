public class ListaObj<T> {

    private T[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    public void adiciona(T elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }

    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.printf("---------------------DREAM HOUSE-------------------------\n\n");
            System.out.printf("%-6s %-12s %-20s %-7s %8s %19s %19s %25s %20s %10s\n",
                    "ID", "PUBLICAÇÃO", "DESCRIÇÃO", "INICIO", "FIM",
                    "CIDADE", "BAIRRO", "LOGRADOURO", "NUMERO", "NOTA");

            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
            System.out.printf("---------------------DREAM HOUSE-------------------------\n\n");

        }
    }

    public void exibeDetalhes(){
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.printf("---------------------DREAM HOUSE-------------------------\n\n");
            System.out.printf("%-6s %10s %10s %10s %14s %16s %18s %20s %15s %15s %15s\n",
                    "ID", "DIARIA", "SEMANAL", "MENSAL", "VALOR DIARIA",
                    "VALOR SEMANAL", "VALOR MENSAL", "DORMITORIOS", "TOALETES", "GARAGEM", "MOBILIADA");
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
            System.out.printf("---------------------DREAM HOUSE-------------------------\n");

        }
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;
        return true;
    }

    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        else {
            return vetor[indice];
        }
    }

    public void limpa() {
        nroElem = 0;
    }
}

