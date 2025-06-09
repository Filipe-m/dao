package dao;

import aplication.DB;
import entity.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOImpl implements DisciplinaDAO {

    private final Connection conexao;

    public DisciplinaDAOImpl() throws SQLException {
        this.conexao = DB.getConexao();
    }

    @Override
    public void insert(Disciplina obj) {
        String sql = "INSERT INTO disciplina (idDisciplina, nomeDisciplina, cargaHoraria) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdDisciplina());
            stmt.setString(2, obj.getNomeDisciplina());
            stmt.setInt(3, obj.getCargaHoraria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Disciplina obj) {
        String sql = "UPDATE disciplina SET nomeDisciplina = ?, cargaHoraria = ? WHERE idDisciplina = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, obj.getNomeDisciplina());
            stmt.setInt(2, obj.getCargaHoraria());
            stmt.setInt(3, obj.getIdDisciplina());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM disciplina WHERE idDisciplina = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Disciplina findById(Integer id) {
        String sql = "SELECT * FROM disciplina WHERE idDisciplina = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Disciplina(rs.getInt("idDisciplina"), rs.getString("nomeDisciplina"), rs.getInt("cargaHoraria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Disciplina> findAll() {
        List<Disciplina> lista = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Disciplina(rs.getInt("idDisciplina"), rs.getString("nomeDisciplina"), rs.getInt("cargaHoraria")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}