package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import repository.Conexao;

import java.util.List;

public class Agenda {

    private static EntityManagerFactory emf = Conexao.getEntityManagerFactory();
    private static EntityManager entityManager = emf.createEntityManager();

    public static void adicionarContato(Pessoa pessoa){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static void removerContato(Integer id){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Pessoa.class, id));
            entityManager.getTransaction().commit();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static void atualizarContato(Integer id, String nome, String telefone){
        entityManager.getTransaction().begin();
        Pessoa p = entityManager.find(Pessoa.class, id);
        p.setNome(nome);
        p.setTelefone(telefone);
        entityManager.getTransaction().commit();
    }

    public static void listarContatos(){

        TypedQuery<Pessoa> query = entityManager.createQuery("SELECT p FROM Pessoa as p", Pessoa.class);
        List<Pessoa> lista = query.getResultList();
        System.out.println("=====================================");
        percorrerLista(lista);
        System.out.println("=====================================");
    }

    private static void percorrerLista(List<Pessoa> lista){
        lista.forEach(p -> System.out.println(p));
    }

    public static void closeEntity(){
        try{
            emf.close();
            entityManager.close();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
