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
            throw new IllegalArgumentException("Já existe usuario com esse cpf");
            return;
        }
        this.usuarios.add(usuario);
    }

    public void remover(String cpf) {
        T usuario = buscar(cpf);
        if ( usuario == null){
            throw new IllegalArgumentException("Não encontrou usuario");
        }
        this.usuarios.remove(usuario);

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

    public List<T> mostrarUsuarios() {
        return this.usuarios;
    }



}
