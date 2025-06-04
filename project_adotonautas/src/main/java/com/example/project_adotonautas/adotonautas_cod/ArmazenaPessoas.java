package com.example.project_adotonautas.adotonautas_cod;

import java.util.ArrayList;

public class ArmazenaPessoas {
    private static double valorTotalCompras;
    Pessoa pessoa;
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void AtibuirValor(double valor){
        valorTotalCompras += valor;
    }

    public static double getValorTotalCompras(){
        return valorTotalCompras;
    }

    public static void setPessoas(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static ArrayList<Pessoa> getPessoa() {
        return pessoas;
    }
}
