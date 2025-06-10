public class Aluno {
    String nome;
    String matricula;
    double mediaFinal;

    public Aluno(String nome, String matricula, double mediaFinal) {
        this.nome = nome;
        this.matricula = matricula;
        this.mediaFinal = mediaFinal;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média Final: " + mediaFinal);
        System.out.println("-------------------------");
    }
}
