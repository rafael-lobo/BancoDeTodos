package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Conta {

    // ######################### ATRIBUTOS #########################
    private int numero;
    private Cliente cliente;
    private double saldo;
    private String senha;

    // ######################### MÉTODOS #########################
    public void debitar(double valor){
        saldo -= valor;
    }
    public void creditar(double valor){
        saldo += valor;
    }
    public void gerarNumero(){
        this.numero = new Random(1000).nextInt(9999);
    }
}
