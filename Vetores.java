// Primeiramente, defina a primeira posição da lista como ordenada.
// Em seguida, pegue o primeiro elemento da lista não ordenada e coloque-o na posição correta na lista ordenada.
// Por fim, repita o passo 2 até que todos os elementos da lista não ordenada sejam inseridos na lista ordenada.

import java.util.Scanner;
import java.util.Random;

public class Vetores {
    public static Scanner input = new Scanner(System.in);
    public static Random gerador = new Random(); 

    static void PreencherVetor(int[] vetor, int qntdNumeros) {
        for (int i = 0; i < qntdNumeros; i++) {
            System.out.print("Digite o número na " + (i + 1) + "ª posição: ");
            vetor[i] = input.nextInt();
            // vetor[i] = gerador.nextInt(1000); CODIGO
        }
        System.out.println();
    }

    static void ExibirVetor(int[] vetor, int qntdNumeros) {
        System.out.println();

        for (int i = 0; i < qntdNumeros; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();
        System.out.println();
    }

    static void InsercaoDireta(int[] vetor) {
        System.out.println();
        System.out.println("Método Inserção Direta");
        // Percorre o vetor começando do segundo elemento (índice 1)
        for (int i = 1; i < vetor.length; i++) { 
            // Armazena o valor do elemento atual que será inserido na posição correta
            int atual = vetor[i]; 
            // System.out.println("Atual: " + atual); CODIGO
            
            // j representa o índice do elemento anterior ao atual que será comparado
            int j = i - 1; 
            
            /* 
             * Enquanto não chegarmos ao início do vetor (j >= 0) E
             * o elemento na posição j for maior que o elemento atual,
             * movemos os elementos maiores para a direita
             */
            while (j >= 0 && vetor[j] > atual) { 
                // System.out.println("Comparativo: " + vetor[j] + " (maior)"); CODIGO
                // Move o elemento maior uma posição para frente
                vetor[j + 1] = vetor[j]; 
                // Decrementa j para comparar com o próximo elemento à esquerda
                j--; 
            }
            
            /*
             * Após encontrar a posição correta (onde o elemento anterior é menor ou igual),
             * insere o elemento atual nesta posição
             * (j+1 porque decrementamos j no final do while)
             */
            vetor[j + 1] = atual; 
            
            // Mostra o estado parcial do vetor após esta inserção
            // System.out.println("Vetor parcial: " + Arrays.toString(vetor)); CODIGO
            // System.out.println("================"); CODIGO
        }
    }

    static void SelecaoDireta(int[] vetor) {
        System.out.println("Método Seleção Direta");
        // Percorre o vetor da primeira até a penúltima posição
        for (int i = 0; i < vetor.length - 1; i++) {
            int minIndex = i; // Assume que o menor elemento está na posição atual (i)
            int min = vetor[i]; // Armazena o valor do menor elemento temporário
            
            // Percorre os elementos à frente de i para encontrar o menor valor
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < min) {  // Se encontrar um valor menor, atualiza min e minIndex
                    min = vetor[j];
                    minIndex = j;
                }
            }
            
            // Troca o elemento atual (i) pelo menor encontrado (minIndex), apenas se o menor não estiver na posição atual
            if (minIndex != i) {
                vetor[minIndex] = vetor[i];  // Move o valor da posição i para minIndex
                vetor[i] = min;  // Coloca o menor valor na posição correta (i)
            }
        }
    }

    static void Bolha(int[] vetor) {
        System.out.println("Método Bolha");
        boolean trocou; // Flag para verificar se houve trocas na passagem
        
        // Loop externo: controla o número de passagens
        for (int i = 0; i < vetor.length - 1; i++) {
            trocou = false; // Reinicia a flag a cada nova passagem
            
            // Loop interno: compara elementos adjacentes
            // Observação: A cada passagem, o maior elemento "flutua" para o final,
            // então não precisamos verificar os últimos 'i' elementos novamente.
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                // Se o elemento atual for maior que o próximo, troca-os
                if (vetor[j] > vetor[j + 1]) {
                    // Realiza a troca
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    
                    trocou = true; // Indica que houve troca
                }
            }
            
            // Se não houve trocas nesta passagem, o vetor já está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Digite a quantidade de números: ");
        final int TAMANHO = input.nextInt();
        System.out.println();
        int[] numeros = new int[TAMANHO];

        PreencherVetor(numeros, TAMANHO);
        InsercaoDireta(numeros);
        ExibirVetor(numeros, TAMANHO);

        PreencherVetor(numeros, TAMANHO);
        SelecaoDireta(numeros);
        ExibirVetor(numeros, TAMANHO);

        PreencherVetor(numeros, TAMANHO);
        Bolha(numeros);
        ExibirVetor(numeros, TAMANHO);
    }
}