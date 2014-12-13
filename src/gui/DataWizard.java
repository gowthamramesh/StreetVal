package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataWizard extends JDialog
{

	// Variable Declarations
	private static final long	serialVersionUID	= 1L;
	private static JTabbedPane	tabbedPane;
	private JButton				backButton;
	private JButton				nextButton;
	private JButton				cancelButton;
	private static JDialog		Wizard;
	private JPanel				panel1;
	private JPanel				panel2;
	private JPanel				panel3;
	private JPanel				topPanel;

	// an action listener to be used when an action is performed
	class CancelListener implements ActionListener
	{

		// close and dispose of the window.
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("disposing the window..");
			setVisible(false);
			dispose();
		}
	}

	class BackListener implements ActionListener
	{

		// close and dispose of the window.
		public void actionPerformed(ActionEvent e)
		{
			nextButton.setText("NEXT   >> ");
			int index = tabbedPane.getSelectedIndex();
			if (index != 0)
			{
				tabbedPane.setSelectedIndex(index - 1);
			}
			if (index - 1 == 0)
			{
				backButton.setEnabled(false);
			}
		}
	}

	class NextListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			backButton.setEnabled(true);
			int index = tabbedPane.getSelectedIndex();
			if (index != tabbedPane.getTabCount() - 1)
			{
				tabbedPane.setSelectedIndex(index + 1);
			}
			else
			{
				setVisible(false);
				dispose();
			}
			if (index == tabbedPane.getTabCount() - 2)
			{
				nextButton.setText("FINISH");
			}
		}
	}

	public DataWizard(Frame owner)
	{

		Wizard = new JDialog(owner);
		setTitle("DATA WIZARD");
		setModal(true);
		initComponents();
	}

	private void initComponents()
	{
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		setPreferredSize(new Dimension(screenSize.width - 200,
				screenSize.height - 100));
		setLocation(100, 50);
		setIconImage(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\icon.png")
				.getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		Box buttonBox = new Box(BoxLayout.X_AXIS);

		backButton = new JButton(" <<   BACK");
		backButton.addActionListener(new BackListener());

		cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new CancelListener());
		nextButton = new JButton("NEXT   >> ");
		nextButton.addActionListener(new NextListener());

		initializeTabbedPane();
		backButton.setEnabled(false);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(new Dimension(
				screenSize.width - 200, screenSize.height - 180)));

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

		nextButton.setText("NEXT   >> ");
		topPanel.add(tabbedPane, BorderLayout.CENTER);

		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(new JSeparator(), BorderLayout.NORTH);

		buttonBox.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
		buttonBox.add(Box.createHorizontalStrut(400));
		buttonBox.add(backButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(cancelButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(nextButton);
		buttonPanel.add(buttonBox, java.awt.BorderLayout.WEST);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		pack();

	}

	private void initializeTabbedPane()
	{
		tabbedPane = new JTabbedPane();
		tabbedPane.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{
				int index = tabbedPane.getSelectedIndex();
				if (index == 0)
				{
					backButton.setEnabled(false);
				}
				else
				{
					backButton.setEnabled(true);
				}
				if (index == tabbedPane.getTabCount() - 1)
				{
					nextButton.setText("FINISH");
				}
				else
				{
					nextButton.setText("NEXT   >> ");
				}

			}
		});

	}

	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel label1 = new JLabel("Username:");
		label1.setBounds(10, 15, 150, 20);
		panel1.add(label1);

		JTextField field = new JTextField();
		field.setBounds(10, 35, 150, 20);
		panel1.add(field);

		JLabel label2 = new JLabel("Password:");
		label2.setBounds(10, 60, 150, 20);
		panel1.add(label2);

		JPasswordField fieldPass = new JPasswordField();
		fieldPass.setBounds(10, 80, 150, 20);
		panel1.add(fieldPass);

		addTab("New Panel1", panel1);

	}

	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());

		panel2.add(new JButton("North"), BorderLayout.NORTH);
		panel2.add(new JButton("South"), BorderLayout.SOUTH);
		panel2.add(new JButton("East"), BorderLayout.EAST);
		panel2.add(new JButton("West"), BorderLayout.WEST);
		panel2.add(new JButton("Center"), BorderLayout.CENTER);
		addTab("New Panel2", panel2);
	}

	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3, 2));

		panel3.add(new JLabel("Field 1:"));
		panel3.add(new TextArea());
		panel3.add(new JLabel("Field 2:"));
		panel3.add(new TextArea());
		panel3.add(new JLabel("Field 3:"));
		panel3.add(new TextArea());
		addTab("New Panel3", panel3);
	}

	public JRootPane createRootPane()
	{
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction()
		{
			private static final long	serialVersionUID	= 1L;

			public void actionPerformed(ActionEvent e)
			{
				System.out.println("escaping..");
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane
				.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}

	public static void addTab(String title, JPanel panel)
	{
		tabbedPane.addTab(title, panel);
	}

	public static void showWizardDialog(MainWindow mainFrame)
	{
		if (Wizard == null)
		{
			Wizard = new DataWizard(mainFrame);
		}
		Wizard.setVisible(true);
	}
}
