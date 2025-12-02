package service;
import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;

public class CadastrarUsuario<T extends Usuario> {
    private List<T> listaUsuario;

    public CadastrarUsuario() {
        this.listaUsuario = new ArrayList<>();
    }

    public void adicionar(T usuario) {
        if (buscar(usuario.getCpf()) != null) {
            System.out.println("Já existe usuario com esse cpf"); //vamos criar uma exception pra cá dps
            return;
        }
        this.listaUsuario.add(usuario);
        System.out.println("Cadastro de " + usuario.getNome() + " realizado com sucesso!");
    }

    public void remover(String cpf) {
        T usuario = buscar(cpf);
        if ( usuario != null){
            this.listaUsuario.remove(usuario);
        } else {
            System.out.println("Não encontrou usuario");
        }

    }

    //troquei nome por cpf
    public T buscar(String cpf) {
        for  (T usuario : listaUsuario) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public List<T> mostrar() {
        return this.listaUsuario;
    }



}
