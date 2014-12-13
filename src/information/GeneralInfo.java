package information;

import gui.SetupWizard;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author LENOVO
 *
 */
public class GeneralInfo
{
	private static int			noOfSegments		= 1;
	private static String		location			= "";
	private static String		fileName			= "";
	private static String		fromAnalysisPeriod	= "";
	private static String		toAnalysisPeriod	= "";
	private static String		analystName			= "";

	private static JPanel		generalInfoPanel;
	private static JTextField	locationField;
	private static JTextField	fileNameField;
	private static JTextField	period1;
	private static JTextField	period2;
	private static JTextField	analyst;

	/**
	 * 
	 */
	public static void createPanel()
	{
		generalInfoPanel = new JPanel();
		generalInfoPanel.setLayout(null);

		JLabel label1 = new JLabel("Location");
		label1.setBounds(20, 50, 150, 27);
		generalInfoPanel.add(label1);
		locationField = new JTextField();
		locationField.setBounds(200, 50, 250, 27);
		generalInfoPanel.add(locationField);

		JLabel label2 = new JLabel("FileName");
		label2.setBounds(20, 100, 150, 27);
		generalInfoPanel.add(label2);
		fileNameField = new JTextField();
		fileNameField.setBounds(200, 100, 250, 27);
		generalInfoPanel.add(fileNameField);

		JLabel label3 = new JLabel("Analysis Period (HH:MM)");
		label3.setBounds(20, 150, 150, 27);
		generalInfoPanel.add(label3);
		period1 = new JTextField();
		period1.setBounds(200, 150, 60, 27);
		generalInfoPanel.add(period1);

		JLabel toLabel = new JLabel("to");
		toLabel.setBounds(265, 150, 15, 27);
		generalInfoPanel.add(toLabel);

		period2 = new JTextField();
		period2.setBounds(280, 150, 60, 27);
		generalInfoPanel.add(period2);

		JLabel label4 = new JLabel("Analyst");
		label4.setBounds(20, 200, 150, 27);
		generalInfoPanel.add(label4);
		analyst = new JTextField();
		analyst.setBounds(200, 200, 250, 27);
		generalInfoPanel.add(analyst);

		SetupWizard.addTab("GENERAL INFORMATION", generalInfoPanel);
	}

	public static boolean storeData()
	{
		location = locationField.getText();
		fileName = fileNameField.getText();
		fromAnalysisPeriod = period1.getText();
		toAnalysisPeriod = period2.getText();
		analystName = analyst.getText();
		return true;
	}
}
