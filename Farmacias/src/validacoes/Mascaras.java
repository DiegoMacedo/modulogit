package validacoes;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author macedo
 */
public class Mascaras {

    public MaskFormatter Mascara(String Mascara) {

        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(Mascara);
            F_Mascara.setPlaceholderCharacter(' ');
        } catch (Exception excecao) {
            excecao.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao executar método - public MaskFormatter Mascara(String Mascara):\n" + excecao, "ERRO: (public class Mascaras)", JOptionPane.ERROR_MESSAGE);
        }
        return F_Mascara;
    }
}
