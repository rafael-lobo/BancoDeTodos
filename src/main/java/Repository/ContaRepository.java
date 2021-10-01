package Repository;
import Entities.Conta;
import java.util.ArrayList;
import java.util.List;

// O REPOSITORIO TEM A FUNÇÃO DE:
// - PERSISTÊNCIA DE DADOS
// - ARMAZENAR ITENS EM UMA LISTA
// - LER A LISTA

public class ContaRepository {

    // ######################### SINGLETON ######################
    // VAMOS CRIAR A LISTA DE CONTAS COM OS ELEMENTOS DO TIPO CONTA
    private List<Conta> listaConta;

    // VAMOS CRIAR UMA ÚNICA INSTÂNCIA DO REPOSITORIO E ARMAZENAR EM "INSTANCIA"
    // PARA EXISTIR APENAS UMA LISTA DE CONTAS
    // VAMOS USAR "FINAL" PRA ESSA INSTANCIA SER CONSTANTE
    private static final ContaRepository INSTANCIA = new ContaRepository();

    // VAMOS CRIAR O CONSTRUTOR DO REPOSITORIO COMO PRIVATE PRA NINGUEM TER ACESSO
    private ContaRepository(){
        // VAMOS INICIALIZAR A LISTA DE CONTAS COMO UM ArrayList
        listaConta = new ArrayList<>();
    }

    // VAMOS CRIAR O GET PARA ACESSAR APENAS A INSTÂNCIA
    public static ContaRepository getINSTANCIA(){
        return INSTANCIA;
    }

    // ###################### MÉTODOS ######################
    public Conta buscarConta(int numero){
        return listaConta
                .stream()  // VAI PERCORRER A LISTA DE CONTAS
                .filter(conta -> conta.getNumero() == numero)  // É UM FILTRO QUE VAI PEGAR A CONTA.
                // O PARÂMETRO É UMA FUNÇÃO "SEM NOME"
                // QUE VAI RETORNAR A CONTA QUE TIVER O NUMERO IGUAL AO QUE FOR FORNECIDO EM buscarConta()
                .findFirst()  // VAI PEGAR A PRIMEIRA CONTA COM O "numero" QUE PASSARMOS
                .get();  // PRA PEGAR
    }

    public void cadastrarConta(Conta conta){
        listaConta.add(conta);
    }

}
