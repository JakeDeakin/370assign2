/**
 * 
 * This file is part of the CarParkSimulator Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * CarParkSimulator
 * asgn2Simulators 
 * 20/04/2014
 * 
 */
package asgn2Simulators;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import asgn2Exceptions.SimulationException;

import java.awt.TextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private final Action action = new SwingAction();
	private Simulator sim;

	/**
	 * @param arg0
	 * @throws HeadlessException
	 * @author @author Jake n8509956 and Jamie n8853312
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		setBackground(new Color(192, 192, 192));
		setTitle("CarPark GUI Simulator");
		
		JLabel lblProbabilities = new JLabel("Probabilities");
		lblProbabilities.setBounds(47, 11, 57, 14);
		
		JLabel lblNewLabel = new JLabel("Seed");
		lblNewLabel.setBounds(93, 36, 24, 14);
		
		JLabel lblCarProbability = new JLabel("Car Probability");
		lblCarProbability.setBounds(47, 60, 70, 14);
		
		JLabel lblSmallCarProbabiity = new JLabel("Small Car Probabiity");
		lblSmallCarProbabiity.setBounds(22, 82, 95, 14);
		
		JLabel lblMotorcycleProbability = new JLabel("MotorCycle Probability");
		lblMotorcycleProbability.setBounds(10, 104, 107, 14);
		
		JLabel lblIntendedStayMean = new JLabel("Intended Stay Mean");
		lblIntendedStayMean.setBounds(19, 126, 98, 14);
		
		JLabel lblIntendedStaySd = new JLabel("Intended Stay S.D.");
		lblIntendedStaySd.setBounds(24, 148, 93, 14);
		
		JLabel lblSizes = new JLabel("Sizes");
		lblSizes.setBounds(47, 181, 24, 14);
		
		JLabel lblCarSpaces = new JLabel("Car Spaces");
		lblCarSpaces.setBounds(69, 203, 54, 14);
		
		JLabel lblSmallcarSpaces = new JLabel("Small Car Spaces");
		lblSmallcarSpaces.setBounds(42, 226, 81, 14);
		
		JLabel lblMotorcycleSpaces = new JLabel("MotorCycle Spaces");
		lblMotorcycleSpaces.setBounds(32, 249, 91, 14);
		
		JLabel lblQueueSize = new JLabel("Queue Size");
		lblQueueSize.setBounds(69, 270, 54, 14);
		
		textField = new JTextField();
		textField.setBounds(127, 34, 24, 17);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 80, 24, 17);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 58, 24, 17);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 102, 24, 17);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 124, 24, 17);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 146, 24, 17);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 201, 24, 17);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(127, 224, 24, 17);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(127, 247, 24, 17);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(127, 268, 24, 17);
		textField_9.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.setAction(action);
		btnRun.setBounds(388, 294, 51, 23);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(169, 36, 270, 247);
		getContentPane().setLayout(null);
		getContentPane().add(lblProbabilities);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblCarProbability);
		getContentPane().add(textField);
		getContentPane().add(textArea);
		getContentPane().add(textField_2);
		getContentPane().add(lblIntendedStaySd);
		getContentPane().add(textField_5);
		getContentPane().add(lblSmallCarProbabiity);
		getContentPane().add(lblIntendedStayMean);
		getContentPane().add(lblMotorcycleProbability);
		getContentPane().add(textField_3);
		getContentPane().add(textField_4);
		getContentPane().add(textField_1);
		getContentPane().add(lblCarSpaces);
		getContentPane().add(textField_6);
		getContentPane().add(lblSmallcarSpaces);
		getContentPane().add(textField_7);
		getContentPane().add(lblMotorcycleSpaces);
		getContentPane().add(textField_8);
		getContentPane().add(lblQueueSize);
		getContentPane().add(textField_9);
		getContentPane().add(btnRun);
		getContentPane().add(lblSizes);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Run");
			putValue(SHORT_DESCRIPTION, "Run");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				sim = new Simulator();
			} catch (SimulationException e1) {
			}
		}
	}
}
