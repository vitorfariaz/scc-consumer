package br.com.springContract.springcloudverifierconsumer.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Convidado {

    private String nome;
    private int idade;

    public Convidado() {
    }

    public Convidado(String nome, int idade) {

        this.nome = nome;

        this.idade =  idade;
    }


}

