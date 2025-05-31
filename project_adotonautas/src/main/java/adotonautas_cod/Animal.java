public abstract class Animal {
    protected String nome;
    protected int idade;
    protected String raca;
    protected StatusAdocao statusAdocao;

    public Animal(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.statusAdocao = StatusAdocao.NAO_ADOTADO;
    }

    public boolean isAdotado() {
        return statusAdocao == StatusAdocao.ADOTADO;
    }

    public void setAdotado(boolean adotado) {
        if (adotado) {
            this.statusAdocao = StatusAdocao.ADOTADO;
        } else {
            this.statusAdocao = StatusAdocao.NAO_ADOTADO;
        }
    }

    // Adicionando getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return nome + " (" + raca + ", " + idade + " anos)" + (isAdotado() ? " [Adotado]" : "");
    }
}