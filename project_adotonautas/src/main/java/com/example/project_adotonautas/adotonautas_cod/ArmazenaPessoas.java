package com.example.project_adotonautas.adotonautas_cod;

import java.util.ArrayList;

public class ArmazenaPessoas {
    Pessoa pessoa;
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();



    public static void setPessoas(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static ArrayList<Pessoa> getPessoa() {
        return pessoas;
    }
}
