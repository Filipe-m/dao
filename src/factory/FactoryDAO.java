package factory;

import dao.DisciplinaDAO;
import dao.DisciplinaDAOImpl;

import java.sql.SQLException;

public class FactoryDAO {

    public static DisciplinaDAO createDisciplinaDAO() {
        try {
            return new DisciplinaDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar DisciplinaDAO", e);
        }
    }
}