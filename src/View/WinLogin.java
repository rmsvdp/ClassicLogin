package View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.GestorLogin;
import Model.Claves;

public class WinLogin {

	public GestorLogin ctrl;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinLogin window = new WinLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinLogin() {
		initialize();
		Claves accesosPermitidos = new Claves();
		ctrl = new GestorLogin(accesosPermitidos); // Inicio el controlador;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Acceso al Sistema");
	}

	private void apply(Integer result) {
		String str;
		if (result == 1) str = "Usuario o contraseña incorrectos!";
		else str = "Agotados el numero de intentos!";
		JOptionPane.showConfirmDialog(frame,str);
		if (result == 0) endApp();
	}
	
	private void endApp() {
		
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.dispose();
	}
	class CustListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			String ac = ev.getActionCommand();
			Integer result = 0;
			switch(ac) {
			case "Aceptar":
				result = ctrl.CheckAccess("u", "p");
				if (result==-1) {
					JOptionPane.showConfirmDialog(frame,"Acceso permitido !"); 
					endApp();
				}
				else apply(result);
				break;
			case "Cancelar": 
				endApp();
				break;

			}
		}
	} // Inner Class CustListener
	
}
