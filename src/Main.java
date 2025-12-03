import entidades.Passageiro;
import entidades.Usuario;
import service.CadastrarUsuario;

public class Main {
    public static void main(String[] args) {
        // adicionando usuários
        CadastrarUsuario<Usuario> cadastro = new CadastrarUsuario<>();
        cadastro.adicionar(new Passageiro("727323728878","João15@gmail.com","João","AEIOU","619874837","Dinheiro"));
    }
}
