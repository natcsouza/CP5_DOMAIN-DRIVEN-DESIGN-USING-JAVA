package br.com.fiap.view;

/*
Felipe Ishii 565339
Vitória Rodrigues 565160
Rodrigo Carvalho 565162
Augusto Bonomo 565155
Nathanael Vieira 564990
 */

import br.com.fiap.controller.FilmeController;
import br.com.fiap.model.dto.Filme;

import javax.swing.*;
import java.util.ArrayList;

public class FilmeView {
    public static void main(String[] args) {
        String titulo, genero, produtora;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        int opcao, codigo;
        FilmeController filmeController = new FilmeController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo:", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        titulo = JOptionPane.showInputDialog("Digite o TITULO do filme");
                        genero = JOptionPane.showInputDialog("Digite o GENERO do filme");
                        produtora = JOptionPane.showInputDialog("Digite o PRODUTORA do filme");

                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o CÓDIGO do filme"));
                        titulo = JOptionPane.showInputDialog("Digite o TITULO do filme");
                        genero = JOptionPane.showInputDialog("Digite o GENERO do filme");
                        produtora = JOptionPane.showInputDialog("Digite o PRODUTORA do filme");

                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;

                    case 2:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o CÓDIGO do filme"));

                        System.out.println(filmeController.excluirFilme(codigo));
                        break;

                    case 3:
                        ArrayList<Filme> resultado = filmeController.listarTodosFilmes();
                        String lista = "";
                        if (resultado != null) {
                            for(Filme filme : resultado) {
                                lista = lista + String.format("Titulo: %s | Genero: %s | Produtora: %s \n", filme.getTitulo(), filme.getGenero(), filme.getProdutora());
                            }
                        }
                        JOptionPane.showMessageDialog(null, lista);

                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa");
    }
}
