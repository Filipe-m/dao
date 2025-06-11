package aplication;

import entity.Disciplina;
import service.DisciplinaServico;

public class Main {
    public static void main(String[] args) {
        DisciplinaServico servico = new DisciplinaServico();

        Disciplina disciplina1 = new Disciplina(1, "Matemática", 60);
        Disciplina disciplina2 = new Disciplina(2, "Física", 45);
        servico.cadastrar(disciplina1);
        servico.cadastrar(disciplina2);

        disciplina1.setCargaHoraria(70);
        servico.alterar(disciplina1);

        Disciplina encontrada = servico.localizar(1);
        if (encontrada != null) {
            System.out.println("Disciplina encontrada: " + encontrada.getNomeDisciplina() + " - " + encontrada.getCargaHoraria() + " horas");
        } else {
            System.out.println("Disciplina não encontrada.");
        }

        System.out.println("\nLista de disciplinas:");
        for (Disciplina d : servico.listar()) {
            System.out.println(d.getIdDisciplina() + " - " + d.getNomeDisciplina() + " - " + d.getCargaHoraria() + " horas");
        }

        servico.apagar(2);
        System.out.println("\nDisciplina com ID 2 foi removida.");

        System.out.println("\nLista de disciplinas atualizada:");
        for (Disciplina d : servico.listar()) {
            System.out.println(d.getIdDisciplina() + " - " + d.getNomeDisciplina() + " - " + d.getCargaHoraria() + " horas");
        }
    }
}