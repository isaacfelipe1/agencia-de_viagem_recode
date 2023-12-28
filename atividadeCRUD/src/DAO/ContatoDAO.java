package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.conexao;
import entidades.contato;

public class ContatoDAO {
    public void enviarMensagem(contato contato){
        String sql="INSERT INTO CONTATO (nome, sobrenome,email, mensagem) VALUES (?,?,?,?)";
        PreparedStatement ps=null;
        try {
           ps= conexao.getConexao().prepareStatement(sql); 
           ps.setString(1, contato.getNome());
           ps.setString(2, contato.getSobrenome());
           ps.setString(3, contato.getEmail());
           ps.setString(4, contato.getMensagem());
           ps.execute();
           ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void atualizarMensagem(contato contato) {
        // Verifica se o ID existe antes de tentar atualizar
        if (verificarIdContatoExistente(contato.getIdcontato())) {
            String sql = "UPDATE CONTATO SET nome=?, sobrenome=?, email=?, mensagem=? WHERE idcontato=?";
            try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
                ps.setString(1, contato.getNome());
                ps.setString(2, contato.getSobrenome());
                ps.setString(3, contato.getEmail());
                ps.setString(4, contato.getMensagem());
                ps.setInt(5, contato.getIdcontato());
                ps.execute();
                System.out.println("Mensagem de contato atualizada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar mensagem de contato:");
                e.printStackTrace();
            }
        } else {
            System.out.println("ID de contato não encontrado. A atualização não foi realizada.");
        }
    }
    
    public boolean verificarIdContatoExistente(int idContato) {
        String sql = "SELECT COUNT(*) FROM CONTATO WHERE idcontato=?";
        try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idContato);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
  // ContatoDAO.deletarMensagem
public void deletarMensagem(int id) {
  
    if (verificarIdExistente(id)) {
        String sql = "DELETE FROM CONTATO WHERE idcontato=?";
        try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Mensagem de contato deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar mensagem de contato:");
            e.printStackTrace();
        }
    } else {
        System.out.println("ID de contato não encontrado.");
    }
}
private boolean verificarIdExistente(int id) {
    String sql = "SELECT COUNT(*) FROM CONTATO WHERE idcontato=?";
    try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; 
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


}
