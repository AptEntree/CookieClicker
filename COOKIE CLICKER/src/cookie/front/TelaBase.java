package cookie.front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cookie.controller.Starter;
import cookie.objects.PowerUp;
import cookie.objects.Supporter;

public class TelaBase extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Supporter> supporter;
	private ArrayList<PowerUp> powerUp;
	private ArrayList<JButton> supporterButton;
	private ArrayList<JButton> powerUpButton;
	
	private JPanel panel;
	private JLabel contador;
	private JButton click;
	private int clickValue;
	private int pointer;
	
	
	public TelaBase() {
		
		clickValue = 1;
		pointer = -1;
		
		supporter = new ArrayList<>();
		powerUp = new ArrayList<>();
		supporterButton = new ArrayList<>();
		powerUpButton = new ArrayList<>();
		
		
		panel = new JPanel();
		contador = new JLabel("0");
		click = new JButton("Aperta");
		
		Starter st = new Starter(supporter, powerUp);
		supporter = st.startSup();
		powerUp = st.startPow();
		
		createButtonArray();
		createButtonsListners();
		
		NoClick thread = new NoClick();
		thread.start();
	}
	private void createButtonArray() {
		for (int i = 0; i < supporter.size(); i++) {
			supporterButton.add(new JButton(supporter.get(i).getName()));
			
		}
		for (int i = 0; i < powerUp.size(); i++) {
			powerUpButton.add(new JButton(powerUp.get(i).getName()));
		}
	}
	private void createButtonsListners() {
		click.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				acrescentar(clickValue);
			}
		});
		
		for (int i = 0; i < supporterButton.size(); i++) {
			supporterButton.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < supporterButton.size(); j++) {
						if(e.getSource().equals(supporterButton.get(j))) {
							pointer = j;
						}
					}
					if(Integer.parseInt(contador.getText()) >= supporter.get(pointer).getPrice()) {
						contador.setText(String.valueOf(
									Integer.parseInt(contador.getText()) - supporter.get(pointer).getPrice())
								);
						supporter.get(pointer).setQtd(supporter.get(pointer).getQtd() + 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Dinheiro Insufuciente");
					}
					
				}
			});
		}
		for (int i = 0; i < powerUpButton.size(); i++) {
			pointer = i;
			powerUpButton.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clickValue += (int)powerUp.get(pointer).getBasePower() * powerUp.get(pointer).getModfier();
				}
			});
		}
	}
	public void starter() {
		panel.add(contador);
		panel.add(click);
		
		for (int i = 0; i < supporterButton.size(); i++) {
			panel.add(supporterButton.get(i));
		}
		for (int i = 0; i < powerUpButton.size(); i++) {
			panel.add(powerUpButton.get(i));
		}
		
		this.add(panel);
		this.setTitle("Cookie Clicker");
		this.setVisible(true);
		this.setSize(500, 500);		
	}
	private void acrescentar(int x) {
		contador.setText(String.valueOf(Integer.valueOf(contador.getText()) + x));
	}
	private class NoClick extends Thread{
		@Override
		public void run() {
			while(true){
				for (int i = 0; i < supporter.size(); i++) {
					acrescentar(supporter.get(i).getQtd() * supporter.get(i).getValuePs());
				}
				try {
					sleep(1000); 										
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
