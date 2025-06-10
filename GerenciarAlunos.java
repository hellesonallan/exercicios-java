import java.util.Scanner;

public class GerenciarAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] todosAlunos = new Aluno[10];
        int aprovadosCount = 0;
        int reprovadosCount = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite a matrícula do aluno " + (i + 1) + ": ");
            String matricula = scanner.nextLine();

            System.out.print("Digite a média final do aluno " + (i + 1) + ": ");
            double mediaFinal = Double.parseDouble(scanner.nextLine());

            todosAlunos[i] = new Aluno(nome, matricula, mediaFinal);

            if (mediaFinal >= 5.0) {
                aprovadosCount++;
            } else {
                reprovadosCount++;
            }
        }

        Aluno[] aprovados = new Aluno[aprovadosCount];
        Aluno[] reprovados = new Aluno[reprovadosCount];
        int apIndex = 0, rpIndex = 0;

        for (Aluno aluno : todosAlunos) {
            if (aluno.mediaFinal >= 5.0) {
                aprovados[apIndex++] = aluno;
            } else {
                reprovados[rpIndex++] = aluno;
            }
        }

        System.out.println("\n===== Alunos Aprovados =====");
        for (Aluno aluno : aprovados) {
            aluno.exibirDados();
        }

        System.out.println("\n===== Alunos Reprovados =====");
        for (Aluno aluno : reprovados) {
            aluno.exibirDados();
        }

        scanner.close();
    }
}
