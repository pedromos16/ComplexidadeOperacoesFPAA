import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int qtdTrocasBolha = 0;
    static int qtdCompBolha = 0;
    static int qtdTrocasSelecao = 0;
    static int qtdCompSelecao = 0;

    static int[] totalTrocaBolha = new int[50];
    static int[] totalCompBolha = new int[50];
    static int[] totalTrocaSelecao = new int[50];
    static int[] totalCompSelecao = new int[50];

    public static void main(String[] args) throws Exception {
        //long tempoInicial = System.currentTimeMillis();
        int total = 0;
        //List<Integer> gerado = geraVetor(100_000), a = gerado, b = gerado;
        //a = new LinkedList<>(gerado);
        //b = new LinkedList<>(gerado);

        for (int i = 0; i < 1; i++) {
            List<Integer> gerado = geraVetor(100_000), a = gerado;
            a = new LinkedList<>(gerado);
            Integer[] y = gerado.toArray(new Integer[0]), x = a.toArray(new Integer[0]);
            selection(y, i);
            bubble(x, i);
        }
        mergeSort(totalCompBolha);
        for (int i = 0; i < totalCompBolha.length; i++) {
        System.out.println(totalCompBolha[i]);

        }
        System.out.println("-------------------------------------");
        System.out.println("Bolha:");
        System.out.println("------------Comparacoes--------------");
        System.out.println("Menor: " + totalCompBolha[0] + "------- Maior:D " + totalCompBolha[totalCompBolha.length - 1]);
        for (int i = 0; i < totalCompBolha.length; i++) {
            total = +totalCompBolha[i];
        }
        System.out.println("Média: " + total / totalCompBolha.length);
        total = 0;
        mergeSort(totalTrocaBolha);
        System.out.println("-------------------------------------");
        System.out.println("------------Trocas-------------------");
        System.out.println("Menor: " + totalTrocaBolha[0] + "------- Maior: " + totalTrocaBolha[totalTrocaBolha.length - 1]);
        for (int i = 0; i < totalTrocaBolha.length; i++) {
            total = +totalTrocaBolha[i];
        }
        System.out.println("Media: " + total / totalTrocaBolha.length);
        total = 0;
        mergeSort(totalCompSelecao);
        System.out.println("-------------------------------------");
        System.out.println("Selecao:");
        System.out.println("------------Comparacoes--------------");
        System.out.println("Menor: " + totalCompSelecao[0] + " ------- Maior: " + totalCompSelecao[totalCompSelecao.length - 1]);
        for (int i = 0; i < totalCompSelecao.length; i++) {
            total = +totalCompSelecao[i];
        }
        System.out.println("Media: " + total / totalCompSelecao.length);
        total = 0;
        mergeSort(totalTrocaSelecao);
        System.out.println("-------------------------------------");
        System.out.println("------------Trocas-------------------");
        System.out.println("Menor: " + totalTrocaSelecao[0] + " ------- Maior: " + totalTrocaSelecao[totalTrocaSelecao.length - 1]);
        for (int i = 0; i < totalTrocaSelecao.length; i++) {
            total = +totalTrocaSelecao[i];
        }
        System.out.println("Media: " + total / totalTrocaSelecao.length);
        //long tempoFinal = System.currentTimeMillis();
        //System.out.println(tempoFinal-tempoInicial);
    }

    /**
     * @param numbersNeeded é o tamanho do vetor
     * @return uma lista com todos os dados embaralhados
     * @throws Exception
     */

    public static List<Integer> geraVetor(int numbersNeeded) throws Exception {
        List<Integer> novo = new LinkedList<Integer>();
        for (int i = 0; i < numbersNeeded; i++) {
            novo.add(i + 1);
        }
        Collections.shuffle(novo);
        return novo;
    }


    /**
     * Selection sort, ordena o conjunto de dados de uma maneira simples, trocando
     */

    public static void selection(Integer[] arr, int pos) {
        int tam = arr.length;
        for (int i = 0; i < tam - 1; i++) {
            int index = i;
            for (int j = i + 1; j < tam; j++) {
                qtdCompSelecao++;
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            qtdTrocasSelecao++;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        totalTrocaSelecao[pos] = qtdTrocasSelecao;
        totalCompSelecao[pos] = qtdCompSelecao;
    }

    /**
     * Bubble sort, ordena o conjunto de dados de uma maneira mais elaborada,
     * "borbulhando" os maiores valores para o final do vetor
     */

    public static void bubble(Integer arr[], int pos) {
        int aux = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                qtdCompBolha++;
                if (arr[j] > arr[j + 1]) {
                    qtdTrocasBolha++;
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
        totalTrocaBolha[pos] = qtdTrocasBolha;
        totalCompBolha[pos] = qtdCompBolha;
    }

    private static void mergeSort(int[] vetor) {
    /* Variavel utilizada para percorrer o vetor.
      Inicializa com 1 para indicar que o vetor tenha pelo menos 1 elemento. */
        int elementos = 1;
        /* Variaveis utilizadas para marcar o inicio, meio e fim do vetor. */
        int inicio, meio, fim;
        int tamanho = vetor.length;
        /* Percorre os elementos do vetor até chegar no fim do vetor. */
        while (elementos < tamanho) {
            /* Aponta o inicio do vetor. */
            inicio = 0;

      /* Percorre o vetor do inicio + quantidade de elementos ja percorrido,
        até o tamanho do vetor. */
            while (inicio + elementos < tamanho) {
                /* Guarda a posição do meio do vetor que será ordenado. */
                meio = inicio + elementos;
                /* Guarda a posição final do vetor que será ordenado. */
                fim = inicio + 2 * elementos;

        /* Caso o fim fique com um tamanho maior, que o tamanho do vetor,
         então faz o fim ter o mesmo tamanho que o tamanho do vetor. */
                if (fim > tamanho)
                    fim = tamanho;

        /* Chama o método que faz a intercalação dos valores
          ordenados do vetor. */
                intercala(vetor, inicio, meio, fim);

                /* Faz o inicio do vetor ser igual ao fim. */
                inicio = fim;
            }

            /* Percorre o vetor dobrando a quantidade de itens ja ordenados. */
            elementos = elementos * 2;
        }


    }

    private static void intercala(int[] vetor, int inicio, int meio, int fim) {
        /* Vetor utilizado para guardar os valors ordenados. */
        int novoVetor[] = new int[fim - inicio];
        /* Variavel utilizada para guardar a posicao do inicio do vetor. */
        int i = inicio;
        /* Variavel utilizada para guardar a posição do meio do vetor. */
        int m = meio;
    /* Variavel utilizada para guarda a posição onde os
      valores serão inseridos no novo vetor. */
        int pos = 0;

    /* Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
      não chegar até seu fim, compara os valores entre o inicio e o meio,
      verificando em qual ordem vai guarda-los ordenado.*/
        while(i < meio && m < fim) {
      /* Se o vetor[i] for menor que o vetor[m], então guarda o valor do
        vetor[i] pois este é menor. */
            if(vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
                // Senão guarda o valor do vetor[m] pois este é o menor.
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        // Adicionar no vetor os elementos que estão entre o inicio e meio,
        // que ainda não foram adicionados no vetor.
        while(i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        // Adicionar no vetor os elementos que estão entre o meio e o fim,
        // que ainda não foram adicionados no vetor.
        while(m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        // Coloca no vetor os valores já ordenados.
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }

}
