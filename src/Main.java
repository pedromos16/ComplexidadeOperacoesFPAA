import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int qtdTrocasBolha = 0;
    static int qtdCompBolha = 0;
    static int qtdTrocasSelecao = 0;
    static int qtdCompSelecao = 0;

    static List <Integer> totalTrocaBolha = new LinkedList<Integer>();
    static List <Integer> totalCompBolha = new LinkedList<Integer>();
    static List <Integer> totalTrocaSelecao = new LinkedList<Integer>();
    static List <Integer> totalCompSelecao = new LinkedList<Integer>();

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
            selection(y);
            bubble(x);
        }
        Collections.sort(totalCompBolha);
        for (int i = 0; i < 400; i++) {
            System.out.println(totalCompBolha.get(i));

        }
        System.out.println("-------------------------------------");
        System.out.println("Bolha:");
        System.out.println("------------Comparacoes--------------");
        System.out.println("Menor: "+totalCompBolha.get(0)+"------- Maior:D "+totalCompBolha.get(totalCompBolha.size()-1));
        //System.out.println("Menor: "+Collections.min(totalCompBolha)+"------- Maior: "+Collections.max(totalCompBolha));
        for (int i = 0; i < totalCompBolha.size(); i++) {
            total=+totalCompBolha.get(i);
        }
        System.out.println("Média: "+total/totalCompBolha.size());
        total=0;
        Collections.sort(totalTrocaBolha);
        System.out.println("-------------------------------------");
        System.out.println("------------Trocas-------------------");
        System.out.println("Menor: "+totalTrocaBolha.get(0)+"------- Maior: "+totalTrocaBolha.get(totalTrocaBolha.size()-1));
        for (int i = 0; i < totalTrocaBolha.size(); i++) {
            total=+totalTrocaBolha.get(i);
        }
        System.out.println("Media: "+total/totalTrocaBolha.size());
        total=0;
        Collections.sort(totalCompSelecao);
        System.out.println("-------------------------------------");
        System.out.println("Selecao:");
        System.out.println("------------Comparacoes--------------");
        System.out.println("Menor: "+totalCompSelecao.get(0)+" ------- Maior: "+totalCompSelecao.get(totalCompSelecao.size()-1));
        for (int i = 0; i < totalCompSelecao.size(); i++) {
            total=+totalCompSelecao.get(i);
        }
        System.out.println("Media: "+total/totalCompSelecao.size());
        total=0;
        Collections.sort(totalTrocaSelecao);
        System.out.println("-------------------------------------");
        System.out.println("------------Trocas-------------------");
        System.out.println("Menor: "+totalTrocaSelecao.get(0)+" ------- Maior: "+totalTrocaSelecao.get(totalTrocaSelecao.size()-1));
        for (int i = 0; i < totalTrocaSelecao.size(); i++) {
            total=+totalTrocaSelecao.get(i);
        }
        System.out.println("Media: "+total/totalTrocaSelecao.size());
        //long tempoFinal = System.currentTimeMillis();
        //System.out.println(tempoFinal-tempoInicial);
    }

    /**
     *
     * @param numbersNeeded é o tamanho do vetor
     * @return uma lista com todos os dados embaralhados
     * @throws Exception
     */

    public static List<Integer> geraVetor(int numbersNeeded) throws Exception{
        List<Integer> novo = new LinkedList<Integer>();
        for (int i = 0; i < numbersNeeded; i++) {
            novo.add(i+1);
        }
        Collections.shuffle(novo);
        return novo;
    }


    /**
     * Selection sort, ordena o conjunto de dados de uma maneira simples, trocando
     */

    public static void selection(Integer[] arr){
        int tam = arr.length;
        for (int i = 0; i < tam - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < tam; j++){
                qtdCompSelecao++;
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            qtdTrocasSelecao++;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        totalTrocaSelecao.add(qtdTrocasSelecao);
        totalCompSelecao.add(qtdCompSelecao);
    }

    /**
     * Bubble sort, ordena o conjunto de dados de uma maneira mais elaborada,
     * "borbulhando" os maiores valores para o final do vetor
     */

    public static void bubble(Integer arr[]) {
        int aux = 0;
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr.length-1; j++){
                qtdCompBolha++;
                if(arr[j] > arr[j + 1]){
                    qtdTrocasBolha++;
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }
        totalTrocaBolha.add(qtdTrocasBolha);
        totalCompBolha.add(qtdCompBolha);
    }
}