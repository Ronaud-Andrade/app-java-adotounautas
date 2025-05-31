public enum StatusAdocao {
    ADOTADO(true),
    NAO_ADOTADO(false);

    private boolean valor;

    StatusAdocao(boolean valor) {
        this.valor = valor;
    }

    public boolean getValor() {
        return valor;
    }
}