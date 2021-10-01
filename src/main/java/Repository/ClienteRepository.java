package Repository;

// O REPOSITORIO TEM A FUNÇÃO DE:
// - PERSISTÊNCIA DE DADOS
// - ARMAZENAR OS CLIENTES EM UMA LISTA (ADICIONA ITENS E LÊ A LISTA)

import Entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    // ######################### SINGLETON #########################
    // VAMOS CRIAR A LISTA DE CLIENTES COM OS ELEMENTOS DO TIPO CLIENTE
    private List<Cliente> listaClientes;

    // VAMOS CRIAR UMA ÚNICA INSTÂNCIA DO REPOSITORIO E ARMAZENAR EM "INSTANCIA"
    // PARA EXISTIR APENAS UMA LISTA DE CLIENTES
    // VAMOS USAR "FINAL" PRA ESSA INSTANCIA SER CONSTANTE
    private static final ClienteRepository INSTANCIA = new ClienteRepository();

    // VAMOS CRIAR O CONSTRUTOR DO REPOSITORIO COMO PRIVATE PRA NINGUEM TER ACESSO
    private ClienteRepository(){
        // VAMOS INICIALIZAR A LISTA DE CLIENTES COMO UM ArrayList
        listaClientes = new ArrayList<>();
    }

    // VAMOS CRIAR O GET PARA ACESSAR APENAS A INSTÂNCIA
    public static ClienteRepository getINSTANCIA() {
        return INSTANCIA;
    }

    // ######################### MÉTODOS #########################
    public Cliente buscarCliente(String cpf){
        return listaClientes
                .stream()  // VAI PERCORRER A LISTA
                .filter(cliente -> cliente.getCpf().equals(cpf))  // É UM FILTRO QUE VAI PEGAR O CLIENTE.
                // O PARÂMETRO É UMA FUNÇÃO "SEM NOME"
                // QUE VAI RETORNAR O CLIENTE QUE TIVER O CPF IGUAL AO QUE FOR FORNECIDO EM buscarCliente()
                .findFirst()  // VAI PEGAR O PRIMEIRO CLIENTE COM O cpf QUE PASSARMOS
                .get();  // PRA PEGAR
    }

    public void cadastrarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

}
