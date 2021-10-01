package Services;
import Entities.Cliente;
import Entities.Conta;
import Repository.ClienteRepository;
import Repository.ContaRepository;
import Util.CpfUtil;

// SERVIÇOS SÃO AS REGRAS DE NEGÓCIOS

public class ContaService {

    // VAMOS CHAMAR OS REPOSITORIOS
    private ContaRepository contaRepository;  // !ECA
    private ClienteRepository clienteRepository;

    // VAMOS CRIAR O CONSTRUTOR
    public ContaService(){
        contaRepository = ContaRepository.getINSTANCIA(); // PARA PEGAR A INSTÂNCIA ÚNICA DO REPOSITORIO
        clienteRepository = ClienteRepository.getINSTANCIA();
        // VAMOS SEMPRE PEGAR O MESMO ESPAÇO DE MEMORIA QUE ESTÁ ARMAZENADO NA "INSTANCIA"
    }

    // ###################### MÉTODOS ######################
    // VAMOS CRIAR UM MÉTODO CHAMANDO O MÉTODO DO REPOSITORIO
    // POR QUE A CAMADA DE SERVIÇO SÓ ACESSA A CAMADA IMEDIATAMENTE ABAIXO (REPOSITORIO)

    public Conta cadastrarConta(String nome, String cpf, String senha){
        Conta conta = new Conta();   // VAMOS CRIAR UMA CONTA VAZIA PARA ARMAZENAR OS DADOS NELA
        Cliente cliente = new Cliente();   // VAMOS CRIAR UM CLIENTE VAZIO PARA ARMAZENAR OS DADOS DOS PARÂMETROS NELE

        // VALIDAÇÃO DO NOME
        if(nome.equals("Jair")){  // JAIR NÃO PODE SER CADASTRADO
            return null;
        }

        // VALIDAÇÃO DO CPF
        if(!CpfUtil.isCPF(cpf)){
            return null;
        }

        // SETAR DADOS EM CLIENTE E CONTA
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        // JOGAMOS O CLIENTE PARA A CONTA
        conta.setCliente(cliente);
        conta.gerarNumero();
        conta.setSaldo(0);
        conta.setSenha(senha);

        // AGORA JOGAMOS A CONTA PARA SER CADASTRADA
        contaRepository.cadastrarConta(conta);

        return conta;
    }

    public Conta buscarConta(int numero){
        // PARA FAZER: VALIDAR SE O NUMERO DA CONTA EXISTE

        Conta conta = contaRepository.buscarConta(numero);
        return conta;
    }
}
