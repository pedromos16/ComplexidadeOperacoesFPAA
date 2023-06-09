import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Enunciado:
 * Estudamos, durante as aulas da disciplina, como a complexidade de tempo (custo de execução) de um
 * algoritmo pode impactar o tempo para a obtenção de uma solução para um problema computacional.
 * O cálculo matemático da complexidade do algoritmo dá uma medida segura para compararmos
 * algoritmos e seus comportamentos.
 * Neste exercício, vamos comparar, na prática, as operações realizadas por dois algoritmos diferentes
 * para o mesmo problema: ordenação. Iremos, ainda, tentar perceber que, utilizando dados aleatórios,
 * a média das execuções tende para a média entre os melhores e piores casos.
 * A descrição completa das tarefas segue:
 * PRIMEIRA PARTE
 * a) Crie um método para gerar um vetor contendo 100.000 valores inteiros aleatórios, sem
 * repetição.
 * b) Crie uma cópia do vetor gerado em (a).
 * c) Utilize o método da bolha para ordenar o vetor original, contando quantas operações de
 * comparação de troca e quantas operações de comparação foram realizadas.
 * d) Utilize o método da seleção para ordenar o a cópia (b) do vetor, contando quantas
 * operações de comparação de troca e quantas operações de comparação foram realizadas.
 * e) Repita as operações de (a) até (d) 50 vezes e para este conjunto de testes, registre para cada
 * um dos dois algoritmos:
 * • Maior, menor e média da quantidade de comparações realizadas;
 * • Maior, menor e média da quantidade de trocas realizadas;
 * f) Criar uma tabela e um gráfico comparando os resultados dos dois algoritmos.
 * g) Analisar criticamente esta tabela, utilizando os conhecimentos que você tem sobre os
 * algoritmos.
 * SEGUNDA PARTE
 * a) Utilize um método similar ao da primeira parte para gerar um vetor contendo 10.000 valores
 * inteiros, iniciando em 1 e indo até 10.000 na ordem.
 * b) Sorteie um número entre 1 e 11.000 e faça a busca sequencial por este número no vetor,
 * registrando em qual posição ele foi encontrado (use a posição 10.001 caso ele não exista).
 * c) Repita os passos (a) e (b) 1 milhão de vezes.
 * d) Agrupe os resultados dos contadores de 500 em 500. Explicando: todos os contadores entre
 * 1 e 500 devem ser somados, depois os de 501 a 1000 e assim por diante.
 * e) Faça um gráfico de barras com os resultados obtidos em (d) e comente o resultado.
 * Ressaltando: o documento a ser entregue deve iniciar com as especificações do equipamento e
 * depois, organizadamente e de forma completa, deve apresentar os testes e seus resultados. Tão
 * importante do quantos os testes são a organização do resultado, sua apresentação e seus
 * comentários.
 */

public class Main {

    /**
     * Decalaração de variáveis e vetores globais para me auxiliar na captação
     * e tratativa dos dados
     */

    static long qtdTrocasBolha = 0;
    static long qtdCompBolha = 0;
    static long qtdTrocasSelecao = 0;
    static long qtdCompSelecao = 0;

    static long[] totalTrocaBolha = new long[50];
    static long[] totalCompBolha = new long[50];
    static long[] totalTrocaSelecao = new long[50];
    static long[] totalCompSelecao = new long[50];

    static long[] totalAleatorio = new long[22]; //ou 21

    public static void main(String[] args) throws Exception {
        long total = 0;

        /**
         * Nesse for eu gero 50 vezes um vetor aleatório e faço sua ordenação, separadamente
         * pelo Selection Sort e pelo Bubble Sort
         */
        for (int i = 0; i < 50; i++) {
            List<Integer> gerado = geraVetor(100_000, true), a = gerado;
            a = new LinkedList<>(gerado);
            Integer[] y = gerado.toArray(new Integer[0]), x = a.toArray(new Integer[0]);
            selection(y, i);
            bubble(x, i);
        }

        System.out.print("Parte 1:");

        /**
         * Nessa sequencia de Prints, eu realizo a ordenação dos dados coletados nos algoritmos
         * de seleção e bolha, usando o Merge Sort para uma maior velocidade, para poder saber o
         * menor e maior valor, além de sua média. Está sendo impresso pelo tipo de método e dentro
         * de cada um, imprime também a as comparações e trocas
         */

        mergeSort(totalCompBolha);
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Bolha:");
        System.out.println("------------Comparacoes--------------");
        System.out.println("Menor: " + totalCompBolha[0] + " ------- Maior:D " + totalCompBolha[totalCompBolha.length - 1]);
        for (int i = 0; i < totalCompBolha.length; i++) {
            total = +totalCompBolha[i];
        }
        System.out.println("Média: " + total / totalCompBolha.length);
        total = 0;
        mergeSort(totalTrocaBolha);
        System.out.println("-------------------------------------");
        System.out.println("------------Trocas-------------------");
        System.out.println("Menor: " + totalTrocaBolha[0] + " ------- Maior: " + totalTrocaBolha[totalTrocaBolha.length - 1]);
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

        /*
        // testando se está funcionandoS
        System.out.println();
        for (int i = 0; i < totalCompBolha.length; i++) {
            System.out.print(totalCompBolha[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < totalTrocaBolha.length; i++) {
            System.out.print(totalTrocaBolha[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < totalCompSelecao.length; i++) {
            System.out.print(totalCompSelecao[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < totalTrocaSelecao.length; i++) {
            System.out.print(totalTrocaSelecao[i]+" ");
        }
         */

        System.out.println("Parte 2: ");

        /**
         * Gero um número aleatório a cada iteração do for, no caso 1.000.000 de vezes,
         * e também um vetor ordenado a cada iteração. Criei uma variável "categoria"
         * para me auxiliar a saber em qual espaço entre os valores de 500 o valor vai
         * estar. Implementei uma busca sequencial como foi requisitado e um método
         * "agrupamentoRecursivo" para usar a "categoria" e me retornar em qual espaço
         * de 500 o valor está. Finalmente, somando os valores correspondentes em um
         * vetor "totalAleatorio" para ter os valores finais
         */


        //Para uma testagem mais rápida e eficaz, recomendo colocar o 1.000.000 em 1.000 ou 10.000
        Random aleatorio = new Random();
        int numAle=0, posicao = 0, categoria = 0;
        for (int i = 0; i < 1_000_000; i++) {
            categoria = 0;
            numAle = aleatorio.nextInt(11_000)+1;
            List<Integer> gerado = geraVetor(10_000, false);
            Integer[] y = gerado.toArray(new Integer[0]);
            posicao = pesquisaSequencial(numAle, y);
            categoria = agrupamentoRecursivo(1,500, posicao, categoria);
            totalAleatorio[categoria] = totalAleatorio[categoria] + posicao;
        }

        /**
         * Imprime na tela todos os espaços requistados entre valores de 500 em 500, partindo
         * de 1 e 500, com o valor total da soma de suas posições
         */

        int max=500, min=1;
        for (int i = 0; i < totalAleatorio.length; i++) {
            System.out.println("O valor total do numeros gerados entre "+min+" e "+max+" foi um total de "+totalAleatorio[i]);
            max += 500;
            min += 500;
        }
    }

    /**
     * @param numbersNeeded é o tamanho do vetor
     * @return uma lista com todos os dados embaralhados
     * @throws Exception
     */

    public static List<Integer> geraVetor(int numbersNeeded, boolean embaralhado) throws Exception {
        List<Integer> novo = new LinkedList<Integer>();
        for (int i = 0; i < numbersNeeded; i++) {
            novo.add(i + 1);
        }
        if (embaralhado) {
            Collections.shuffle(novo);
        }
        return novo;
    }


    /**
     * Selection sort, ordena o conjunto de dados de uma maneira simples, trocando
     */

    public static void selection(Integer[] arr, int pos) {
        qtdCompSelecao = 0;
        qtdTrocasSelecao = 0;
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
        qtdTrocasBolha = 0;
        qtdCompBolha = 0;
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

    private static void mergeSort(long[] vetor) {
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

    private static void intercala(long[] vetor, int inicio, int meio, int fim) {
        /* Vetor utilizado para guardar os valors ordenados. */
        long novoVetor[] = new long[fim - inicio];
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

    /**
     * Método utilizado para procurar se um elemento está dentro do vetor.
     * Este método utiliza o algoritmo de Pesquisa Sequencial para encontrar
     * o elemento.
     *
     * @param x    - Número que será procurado.
     * @param numeros - Vetor de números.
     * @return cont ou 10001 - A posição que o número está
     */
    static public Integer pesquisaSequencial(int x, Integer[] numeros) {
        int cont = 0;
        for(cont = 0; cont < numeros.length; cont++) {
            if (numeros[cont] == x) {
                return cont;

            }
        }
        return 10001;
    }

    /**
     * Método recursivo para alocar o valor na catégoria correta, seja entre
     * 1 e 500, 501 e 1000 e etc.
     *
     * @param min - limite mínimo (valor inicial: 1)
     * @param max - Limite máximo (valor inicial: 500)
     * @param posicao - Posição que o valor foi encontrado no vetor
     * @param categoria - Divisões criadas para permitir o agrupamento fácil dos dados
     * @return categoria que o valor se encontra
     */

    static public int agrupamentoRecursivo(int min, int max, int posicao, int categoria){
        if (posicao>= min && posicao<=max) {
            return categoria;
        } else
            return agrupamentoRecursivo(min+500,max+500, posicao, categoria+1);
    }
}


