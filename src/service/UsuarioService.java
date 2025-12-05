package service;
import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;

public class UsuarioService<T extends Usuario> {

    private List<T> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionar(T usuario) {
        if (buscar(usuario.getCpf()) != null) {
            System.out.println("Já existe usuario com esse cpf"); //vamos criar uma exception pra cá dps
            return;
        }
        this.usuarios.add(usuario);
        System.out.println("Cadastro de " + usuario.getNome() + " realizado com sucesso!");
    }

    public void remover(String cpf) {
        T usuario = buscar(cpf);
        if ( usuario != null){
            this.usuarios.remove(usuario);
        } else {
            System.out.println("Não encontrou usuario");
        }

    }

    //troquei nome por cpf
    public T buscar(String cpf) {
        for  (T usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public List<T> mostrar() {
        return this.usuarios;
    }



}
