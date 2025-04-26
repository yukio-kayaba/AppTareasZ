
package z.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import modelo.ArchivosDatos;
import vistas.LogoPrincipalPanel;

public class Inicializador {
    public void iniciarApp(ArchivosDatos valores){
        SwingUtilities.invokeLater(() -> {
            JWindow window = new JWindow();

            

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            window.setSize(60, 60);
            int x = screenSize.width - 60;
            int y = (screenSize.height / 2) - 60 ;
            int y_aux = (screenSize.height / 5);
            window.setLocation(x, y);
            window.setLayout(null);
            LogoPrincipalPanel create = new LogoPrincipalPanel(valores,window);
            create.setCoordenadasPricipales(x, y_aux);
            create.setLargoTamanio(y_aux * 3);
            window.setBackground(new Color(0,0,100));
            //create.setLayout(null);
            create.valoresIniciales(60, 60);
            
            create.setLocation(0, 0);
            create.setSize(60,60);
            create.setOpaque(false);
            create.setVisible(true);
            //window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.X_AXIS));
            window.add(create);
            window.setAlwaysOnTop(true);
            window.setVisible(true);
        });
    }
}
