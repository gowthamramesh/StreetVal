package gui;

import information.CoordinationInfo;
import information.GeneralInfo;
import information.ODSpeedProportion;
import information.SegmentInfo;
import information.SegmentInfoPanel;
import information.SupplementalInfo;
import information.UrbanStreetParameter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
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
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SetupWizard extends JDialog
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private static JTabbedPane	tabbedPane;
	private JButton				backButton;
	private JButton				nextButton;
	private JButton				cancelButton;
	private static JDialog		setupWiz;
	private JPanel				topPanel;

	public SetupWizard(Frame owner)
	{

		setupWiz = new JDialog(owner);
		setTitle("SETUP WIZARD");
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

		initializeTabbedPane();
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(new Dimension(
				screenSize.width - 200, screenSize.height - 180)));

		topPanel.add(tabbedPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		Box buttonBox = new Box(BoxLayout.X_AXIS);

		backButton = new JButton("<<   BACK");
		backButton.addActionListener(new SetupBackAction());
		cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new SetupCancelAction());
		nextButton = new JButton("NEXT   >>");
		nextButton.addActionListener(new SetupNextAction());

		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(new JSeparator(), BorderLayout.NORTH);

		/*
		 * Creating tab panels in SetupWizard
		 */
		GeneralInfo.createPanel();
		UrbanStreetParameter.createPanel();
		SegmentInfoPanel.createPanel();
		CoordinationInfo.createPanel();
		ODSpeedProportion.createPanel();
		SupplementalInfo.createPanel();

		nextButton.setText("NEXT   >>");
		buttonBox.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
		buttonBox.add(Box.createHorizontalStrut(400));
		buttonBox.add(backButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(cancelButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(nextButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonPanel.add(buttonBox, java.awt.BorderLayout.WEST);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		pack();

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
					nextButton.setText("PROCEED TO ENTER SEGMENT DATA");
				}
				else
				{
					nextButton.setText("NEXT   >> ");
				}

			}
		});

	}

	// an action listener to be used when an action is performed
	class SetupCancelAction implements ActionListener
	{

		// close and dispose of the window.
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("disposing the window..");
			setVisible(false);
			dispose();
		}
	}

	class SetupBackAction implements ActionListener
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

	class SetupNextAction implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			int index = tabbedPane.getSelectedIndex();
			boolean result = true;
			switch(index)
			{
				case 0:
					result = GeneralInfo.storeData();
					break;
				case 1:
					result = UrbanStreetParameter.storeData();
					break;
				case 2:
					result = SegmentInfoPanel.storeData();
					break;
				case 3:
					result=ODSpeedProportion.storeData();
					break;
				case 4:
					result=SupplementalInfo.storeData();
					break;
					
			}
			if(result == false)
			{
				return;
			}
			backButton.setEnabled(true);
			if (index != tabbedPane.getTabCount() - 1)
			{
				tabbedPane.setSelectedIndex(index + 1);
			}
			else
			{
				setVisible(false);
				dispose();
				DataWizard.showWizardDialog(MainWindow.getMainFrame());
			}
			if (index == tabbedPane.getTabCount() - 2)
			{
				nextButton.setText("PROCEED TO ENTER SEGMENT DATA");
			}
		}
	}

	public static void addTab(String title, JPanel panel)
	{
		tabbedPane.addTab(title, panel);
	}

	public static void showsetUpWizDialog(MainWindow mainFrame)
	{
		if (setupWiz == null)
		{
			setupWiz = new SetupWizard(mainFrame);
		}
		setupWiz.setVisible(true);
	}
}
