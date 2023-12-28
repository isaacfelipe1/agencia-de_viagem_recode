import DAO.UsuarioDAO;
import DAO.ContatoDAO;
import entidades.usuario;
import entidades.contato;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarNovoUsuario(scanner);
                    break;
                case 2:
                    atualizarUsuarioExistente(scanner);
                    break;
                case 3:
                    deletarUsuario(scanner);
                    break;
                case 4:
                    cadastrarNovaMensagem(scanner);
                    break;
                case 5:
                    atualizarMensagemExistente(scanner);
                    break;
                case 6:
                    deletarMensagem(scanner);
                    break;
                case 7:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Atualizar usuário existente");
        System.out.println("3. Deletar usuário");
        System.out.println("4. Cadastrar nova mensagem de contato");
        System.out.println("5. Atualizar mensagem de contato existente");
        System.out.println("6. Deletar mensagem de contato");
        System.out.println("7. Sair");
        System.out.print("Opção: ");
    }

    private static void cadastrarNovoUsuario(Scanner scanner) {
        usuario novoUsuario = new usuario();
        System.out.print("Nome: ");
        novoUsuario.setNome(scanner.nextLine());
        System.out.print("Login: ");
        novoUsuario.setLogin(scanner.nextLine());
        System.out.print("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());
        System.out.print("Email: ");
        novoUsuario.setEmail(scanner.nextLine());

        try {
            new UsuarioDAO().cadastrarUsuario(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário:");
            e.printStackTrace();
        }
    }

    private static void atualizarUsuarioExistente(Scanner scanner) {
        System.out.print("ID do usuário a ser atualizado: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
    
        usuario usuarioExistente = new usuario();
        usuarioExistente.setIdusuario(idUsuario);
    
        try {
            // Verifica se o ID existe antes de solicitar as informações do usuário
            if (new UsuarioDAO().verificarIdUsuarioExistente(idUsuario)) {
                System.out.print("Novo Nome: ");
                usuarioExistente.setNome(scanner.nextLine());
                System.out.print("Novo Login: ");
                usuarioExistente.setLogin(scanner.nextLine());
                System.out.print("Nova Senha: ");
                usuarioExistente.setSenha(scanner.nextLine());
                System.out.print("Novo Email: ");
                usuarioExistente.setEmail(scanner.nextLine());
    
            
                new UsuarioDAO().atualizarUsuario(usuarioExistente);
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("ID de usuário não encontrado. A atualização não foi realizada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário:");
            e.printStackTrace();
        }
    }
    
    private static void deletarUsuario(Scanner scanner) {
        System.out.print("ID do usuário a ser deletado: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        try {
            new UsuarioDAO().deletarUsuario(idUsuario);
            System.out.println("Usuário deletado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário:");
            e.printStackTrace();
        }
    }

    private static void cadastrarNovaMensagem(Scanner scanner) {
        contato novaMensagem = new contato();
        System.out.print("Nome: ");
        novaMensagem.setNome(scanner.nextLine());
        System.out.print("Sobrenome: ");
        novaMensagem.setSobrenome(scanner.nextLine());
        System.out.print("Email: ");
        novaMensagem.setEmail(scanner.nextLine());
        System.out.print("Mensagem: ");
        novaMensagem.setMensagem(scanner.nextLine());

        try {
            new ContatoDAO().enviarMensagem(novaMensagem);
            System.out.println("Mensagem de contato cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar mensagem de contato:");
            e.printStackTrace();
        }
    }

    private static void atualizarMensagemExistente(Scanner scanner) {
        System.out.print("ID da mensagem de contato a ser atualizada: ");
        int idContato = scanner.nextInt();
        scanner.nextLine();
    
        // Cria um objeto Contato com o ID definido
        contato mensagemExistente = new contato();
        mensagemExistente.setIdcontato(idContato);
    
        try {
            // Verifica se o ID existe antes de solicitar as informações do contato
            if (new ContatoDAO().verificarIdContatoExistente(idContato)) {
                System.out.print("Novo Nome: ");
                mensagemExistente.setNome(scanner.nextLine());
                System.out.print("Novo Sobrenome: ");
                mensagemExistente.setSobrenome(scanner.nextLine());
                System.out.print("Novo E-mail: ");
                mensagemExistente.setEmail(scanner.nextLine());
                System.out.print("Nova Mensagem: ");
                mensagemExistente.setMensagem(scanner.nextLine());
    
                // Atualiza a mensagem apenas se o ID existir
                new ContatoDAO().atualizarMensagem(mensagemExistente);
                System.out.println("Mensagem de contato atualizada com sucesso!");
            } else {
                System.out.println("ID de contato não encontrado. A atualização não foi realizada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar mensagem de contato:");
            e.printStackTrace();
        }
    }
    
    private static void deletarMensagem(Scanner scanner) {
        System.out.print("ID da mensagem de contato a ser deletada: ");
        int idcontato = scanner.nextInt();
        scanner.nextLine(); 
        try {
            new ContatoDAO().deletarMensagem(idcontato);
            System.out.println("Mensagem de contato deletada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar mensagem de contato:");
            e.printStackTrace();
        }
    }
}
