package teste;

import entidade.Medicamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mb.MedicamentoMb;

/**
 *
 * @author macedo
 */
public class Teste {

    public static void main(String args[]) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hli");
//        EntityManager manager = factory.createEntityManager();  
       Medicamento m = new Medicamento();
       MedicamentoMb mb = new MedicamentoMb();
       
       m.setNome("D");
       m.setFornecedor("dds");
       m.setLote("fdf");
       m.setQuantidade(23);
       m.setValidade("21/02/2015");
       m.setControlado(false);
       
       mb.salvar(m);
    }
}
