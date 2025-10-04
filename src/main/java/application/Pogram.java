package application;

import entities.Agenda;
import entities.Pessoa;

import java.util.Scanner;

public class Pogram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolha;

        do{
        System.out.println("=====================================");
        System.out.println("          AGENDA  TELEFÔNICA         ");
        System.out.println("=====================================");
        System.out.println("(1) Adicionar contato");
        System.out.println("(2) Remover contato");
        System.out.println("(3) Atualizar contato");
        System.out.println("(4) Listar contatos");
        System.out.println("(5) SAIR");
        System.out.print("Qual operação deseja realizar: ");
        escolha = sc.nextInt();
        switch(escolha) {
            case 1:
                System.out.print("Nome: ");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                Agenda.adicionarContato(new Pessoa(nome, telefone));
                break;
            case 2:
                Agenda.listarContatos();
                System.out.print("Id do contato a ser removido: ");
                Agenda.removerContato(sc.nextInt());
                break;
            case 3:
                Agenda.listarContatos();
                System.out.print("Id do contato a ser atualizado: ");
                int id = sc.nextInt();
                System.out.print("Novo nome: ");
                sc.nextLine();
                String novoNome = sc.nextLine();
                System.out.print("Novo telefone: ");
                String novoTelefone = sc.nextLine();
                Agenda.atualizarContato(id, novoNome, novoTelefone);
                break;
            case 4:
                Agenda.listarContatos();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção de operação invalida! Digite outra!");
        }
        }while (escolha != 5);
        System.out.println("Operação finalizada com sucesso!");
        sc.close();
        Agenda.closeEntity();
    }
}
