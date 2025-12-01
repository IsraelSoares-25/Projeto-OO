package service;

import java.util.ArrayList;
import model.Usuario;
import javax.swing.*;


public class UsuarioService {
    private ArrayList<Usuario> usuarios;
    public UsuarioService() {
        usuarios = new ArrayList<>();
    }
    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
    }
    public void remover(Usuario usuario) {
        usuarios.remove(usuario);
    }
    public void listar() {
        for  (Usuario usuario : usuarios) {
            JOptionPane.showMessageDialog(null, "Nome: " + usuario.getNome() +
                    "\nSenha: " + usuario.getSenha() +
                    "Telefone: " + usuario.getTelefone() +
                    "Email: " + usuario.getEmail());
        }
    }
    public Usuario buscarUsuario (String nome) {
        for  (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }
}
