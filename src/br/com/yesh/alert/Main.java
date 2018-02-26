package br.com.yesh.alert;

import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Boolean ativo = true;
		while (true) {
			try {
				if (TestePing.TesteConect()) {
					if (ativo == false) {
						ativo = true;
						Date time = new Date();
						System.out.println("ativo");
						Toolkit.getDefaultToolkit().beep();
						String mensagem = "O servidor voltou : " + getHoraRestore(time);
						JOptionPane.showMessageDialog(null, mensagem);
					}
				} else {
					if (ativo == true) {
						ativo = false;
						String mensagem = "Servidor fora do ar!";
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, mensagem);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.toString());
			}
		}
	}

	private static String getHoraRestore(Date time) {
		String result = "";
		String hora = "" + time.getHours();
		String minuto = "" + time.getMinutes();
		String segundo = "" + time.getMinutes();
		hora = (hora.length() == 1) ? "0" + hora : hora;
		minuto = (minuto.length() == 1) ? "0" + minuto : minuto;
		segundo = (segundo.length() == 1) ? "0" + segundo : segundo;
		result = hora + ":" + minuto + ":" + segundo;
		return result;
	}
}
