package dao;

import entidade.Material;
import java.io.Serializable;
import java.sql.SQLException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author macedo
 */
public class MaterialDao extends GenericDAO<Material, Serializable> {

    public void excluirMaterial(Material m) throws SQLException {
        try {
            if (m != null) {
                getEntityManager().getTransaction().begin();
                String hqlDelete = "DELETE FROM material WHERE id="
                        + m.getId();
                Query nativeQuery = getEntityManager().createNativeQuery(
                        hqlDelete);
                nativeQuery.executeUpdate();
                getEntityManager().getTransaction().commit();
            } else {
                System.out.println("Erro na exclusão. Objeto material nulo.");
            }
        } catch (PersistenceException per) {
            per.printStackTrace();
            System.out.println("ERRO ao excluir registro.");
        } catch (GenericJDBCException gex) {
            gex.printStackTrace();
        }

    }

}
