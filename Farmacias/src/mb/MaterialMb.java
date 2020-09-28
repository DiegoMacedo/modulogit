package mb;

import dao.MaterialDao;
import dao.MedicamentoDao;
import entidade.Material;
import entidade.Medicamento;

/**
 *
 * @author macedo
 */
public class MaterialMb {

    MaterialDao dao = new MaterialDao();

    public void salvar(Material material) {
        try {
            dao.salvar(material);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void alterar(Material material) {
        try {
            dao.merge(material);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
