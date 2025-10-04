package repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    public static EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("meuJpa");
    }
}
