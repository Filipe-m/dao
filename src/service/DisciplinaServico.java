package service;

import dao.DisciplinaDAO;
import entity.Disciplina;
import factory.FactoryDAO;

import java.util.List;

public class DisciplinaServico {
    private final DisciplinaDAO disciplinaDAO;

    public DisciplinaServico() {
        this.disciplinaDAO = FactoryDAO.createDisciplinaDAO();
    }

    public void cadastrar(Disciplina obj) {
        disciplinaDAO.insert(obj);
    }

    public void alterar(Disciplina obj) {
        disciplinaDAO.update(obj);
    }

    public void apagar(Integer id) {
        disciplinaDAO.deleteById(id);
    }

    public Disciplina localizar(Integer id) {
        return disciplinaDAO.findById(id);
    }

    public List<Disciplina> listar() {
        return disciplinaDAO.findAll();
    }
}