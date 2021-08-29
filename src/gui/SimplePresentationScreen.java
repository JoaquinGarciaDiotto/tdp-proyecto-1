package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel labelLU;
	private JLabel labelApellido;
	private JLabel labelNombre;
	private JLabel labelEmail;
	private JLabel labelGithub;
	private JLabel labelFecha;
	private JTextField txtGithub;
	private JTextField txtEmail;
	private JTextField txtLU;
	private JTextField txtApellido;
	private JTextField txtNombre;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(747, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		labelLU = new JLabel("LU");
		
		labelApellido = new JLabel("Apellido");
		
		labelNombre = new JLabel("Nombre");
		
		labelEmail = new JLabel("E-mail");
		
		labelGithub = new JLabel("Github URL");
		
		txtGithub = new JTextField();
		txtGithub.setText(studentData.getGithubURL());
		txtGithub.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(studentData.getMail());
		txtEmail.setColumns(10);
		
		txtLU = new JTextField();
		txtLU.setText(""+studentData.getId());
		txtLU.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText(studentData.getLastName());
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText(studentData.getFirstName());
		txtNombre.setColumns(10);
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(labelGithub)
						.addComponent(labelEmail)
						.addComponent(labelNombre)
						.addComponent(labelLU)
						.addComponent(labelApellido))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLU, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(txtApellido, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(txtGithub, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelLU)
						.addComponent(txtLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelGithub)
						.addComponent(txtGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		labelFecha = new JLabel("Esta ventana fue genereada el "+java.time.LocalDate.now()+" a las: "+java.time.LocalTime.now());
		contentPane.add(labelFecha, BorderLayout.SOUTH);
		
		try {
			JLabel labelFoto = new JLabel("");
			labelFoto.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(studentData.getPathPhoto()))));
			contentPane.add(labelFoto, BorderLayout.EAST);
		} catch (IOException e) {e.printStackTrace();}
	}
}
