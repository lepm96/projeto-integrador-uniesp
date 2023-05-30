package App;

import Classes.Endereco;
import Classes.Usuario;
import Classes.Voluntario;
import Conexao.Conexao;
import DAO.EnderecoDAO;
import DAO.UsuarioDAO;
import DAO.VoluntarioDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // PARTE DE CONEXAO COM BANCO
        Conexao conectar = new Conexao();
        conectar.GeraConexao();

        // INSTANCIAR AMBOS OS OBJETOS
        UsuarioDAO userDAO = new UsuarioDAO();
        VoluntarioDAO voluntaryDAO = new VoluntarioDAO();
        EnderecoDAO addressDAO = new EnderecoDAO();

        // TECLADO PARA PEGAR INFORMACOES
        int opcoes;

        // VERIFICACAO PARA UM DOS CASES NO SWITCH
        boolean continuarCadastrando = true;




        // SISTEMA DE CADASTRO DE USUARIO E VOLUNTARIO


        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Olá, bem vindo ao Núcleo de Tecnologia Assistiva!!\n");
            System.out.println("O que deseja fazer?\n");
            System.out.println("1) Cadastrar Usuário");
            System.out.println("2) Cadastrar Voluntário");
            System.out.println("3) Sair");

            opcoes = entrada.nextInt();
            entrada.nextLine();

        switch (opcoes) {

            case 1:
                System.out.println("---ÁREA DE CADASTRO DO USUÁRIO---");

                do {
                    // Obtenha os dados do usuário aqui
                System.out.println("Nome: ");
                String nome = entrada.nextLine();
                System.out.println("Telefone: ");
                String telefone = entrada.nextLine();
                System.out.println("Gênero:");
                String genero = entrada.nextLine();
                System.out.println("CID:");
                String cid = entrada.nextLine();
                System.out.println("Endereço: ");
                String endereco = entrada.nextLine();

                Usuario user = new Usuario();
                user.setNome_usuario(nome);
                user.setTelefone(telefone);
                user.setGenero(genero);
                user.setCid(cid);
                user.setEndereco(endereco);

                UsuarioDAO.adiciona(user);

                    System.out.println("Cadastro realizado com sucesso!!");

                    // VERIFICACAO SE O ADM DESEJA CONTINUAR CADASTRANDO USUARIOS
                    System.out.println("Deseja continuar cadastrando usuários? (S/N)");
                    String resposta = entrada.nextLine();
                    if (resposta.equalsIgnoreCase("N")) {
                        continuarCadastrando = false;
                    }
                } while (continuarCadastrando);
            break;

            case 2:
                System.out.println("---ÁREA DE CADASTRO DE VOLUNTÁRIO---");

                do {
                System.out.println("Nome: ");
                String nome = entrada.nextLine();
                System.out.println("Nacionalidade: ");
                String nacionalidade = entrada.nextLine();
                System.out.println("Estado Civil:");
                String estadoCivil = entrada.nextLine();
                System.out.println("Profissão:");
                String profissao = entrada.nextLine();
                System.out.println("RG: ");
                String rg = entrada.nextLine();
                System.out.println("Òrgão Expedidor: ");
                String orgaoExpedidor = entrada.nextLine();
                System.out.println("CPF: ");
                String cpf = entrada.nextLine();
                System.out.println("Rua:");
                String rua = entrada.nextLine();
                System.out.println("Número:");
                String numero = entrada.nextLine();
                System.out.println("Complemento:");
                String complemento = entrada.nextLine();
                System.out.println("Bairro: ");
                String bairro = entrada.nextLine();
                System.out.println("CEP: ");
                String cep = entrada.nextLine();
                System.out.println("Cidade:");
                String cidade = entrada.nextLine();
                System.out.println("Estado:");
                String estado = entrada.nextLine();

                Voluntario voluntary = new Voluntario();
                voluntary.setNome(nome);
                voluntary.setNacionalidade(nacionalidade);
                voluntary.setEstadoCivil(estadoCivil);
                voluntary.setProfissao(profissao);
                voluntary.setRG(rg);
                voluntary.setOrgaoExpedidor(orgaoExpedidor);
                voluntary.setCPF(cpf);

                Endereco address = new Endereco();
                address.setRua(rua);
                address.setNumero(numero);
                address.setComplemento(complemento);
                address.setBairro(bairro);
                address.setCep(cep);
                address.setCidade(cidade);
                address.setEstado(estado);

                VoluntarioDAO.adiciona(voluntary);
                EnderecoDAO.adiciona(address);

                System.out.println("Cadastro realizado com sucesso!!");

                // VERIFICACAO SE O ADM DESEJA CONTINUAR CADASTRANDO VOLUNTARIOS
                System.out.println("Deseja continuar cadastrando voluntários? (S/N)");
                String resposta = entrada.nextLine();
                if (resposta.equalsIgnoreCase("N")) {
                    continuarCadastrando = false;
                }
        } while (continuarCadastrando);
                break;
            case 3:
                System.out.println("Finalizando programa...");
                System.out.println("...");
                System.out.println("Finalizado!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        } } while(opcoes != 3);


    }
}
