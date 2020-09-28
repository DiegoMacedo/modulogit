package dao;

import entidade.Medicamento;
import java.io.Serializable;
import java.sql.SQLException;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.exception.GenericJDBCException;

public class MedicamentoDao extends GenericDAO<Medicamento, Serializable> {

    public void excluirMedicamento(Medicamento m) throws SQLException {
        try {
            if (m != null) {
                getEntityManager().getTransaction().begin();
                String hqlDelete = "DELETE FROM medicamento WHERE id="
                        + m.getId();
                Query nativeQuery = getEntityManager().createNativeQuery(
                        hqlDelete);
                nativeQuery.executeUpdate();
                getEntityManager().getTransaction().commit();
            } else {
                System.out.println("Erro na exclusão. Objeto medicamento nulo.");
            }
        } catch (PersistenceException per) {
            per.printStackTrace();
            System.out.println("ERRO ao excluir registro.");
        } catch (GenericJDBCException gex) {
            gex.printStackTrace();
        }

    }

}
