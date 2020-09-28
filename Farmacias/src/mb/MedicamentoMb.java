package mb;

import dao.MedicamentoDao;
import entidade.Medicamento;
/**
 *
 * @author macedo
 */
public class MedicamentoMb {

    MedicamentoDao dao = new MedicamentoDao();

    public void salvar(Medicamento medicamento) {
        try {
            dao.salvar(medicamento);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void alterar(Medicamento medicamento) {
        if (medicamento.getId() != null) {
            try {
                dao.merge(medicamento);
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            System.err.println("erro ao tentar modificar");
        }
    }

}
