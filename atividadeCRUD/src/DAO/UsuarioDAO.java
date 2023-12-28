package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexao;
import entidades.usuario;

public class UsuarioDAO {
    public void cadastrarUsuario(usuario usuario){
        String sql="INSERT INTO USUARIO (nome, login,senha, email) VALUES (?,?,?,?)";
        PreparedStatement ps=null;
        try {
           ps= conexao.getConexao().prepareStatement(sql); 
           ps.setString(1, usuario.getNome());
           ps.setString(2, usuario.getLogin());
           ps.setString(3, usuario.getSenha());
           ps.setString(4, usuario.getEmail());
           ps.execute();
           ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void atualizarUsuario(usuario usuario) {
        // Verifica se o ID existe antes de tentar atualizar
        if (verificarIdUsuarioExistente(usuario.getIdusuario())) {
            String sql = "UPDATE USUARIO SET nome=?, login=?, senha=?, email=? WHERE idusuario=?";
            try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getEmail());
                ps.setInt(5, usuario.getIdusuario());
                ps.execute();
                System.out.println("Usuário atualizado com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar usuário:");
                e.printStackTrace();
            }
        } else {
            System.out.println("ID de usuário não encontrado. A atualização não foi realizada.");
        }
    }
    
   public void deletarUsuario(int idUsuario) {
    // Verifica se o ID existe antes de tentar deletar
    if (verificarIdUsuarioExistente(idUsuario)) {
        String sql = "DELETE FROM USUARIO WHERE idusuario=?";
        try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.execute();
            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário:");
            e.printStackTrace();
        }
    } else {
        System.out.println("ID de usuário não encontrado.");
    }
}

public boolean verificarIdUsuarioExistente(int idUsuario) {
    String sql = "SELECT COUNT(*) FROM USUARIO WHERE idusuario=?";
    try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, idUsuario);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Se o ID existe, retorna true
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Se houver algum problema, retorna false por precaução
}

}
