import entidades.Passageiro;
import entidades.Usuario;
import service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        // adicionando usuários
        UsuarioService<Usuario> cadastro = new UsuarioService<>();
        cadastro.adicionar(new Passageiro("727323728878","João15@gmail.com","João","AEIOU","619874837","Dinheiro"));
    }
}
