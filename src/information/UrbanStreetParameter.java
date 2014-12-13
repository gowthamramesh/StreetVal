package information;

import gui.SetupWizard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UrbanStreetParameter
{
	private static JPanel	urbanParaPanel;
	private static float	startupLostTime			= 0;
	private static float	effGreeExtn				= 0;
	private static float	analysisTimePeriod		= 0;
	private static float	criticalMergeHeadway	= 0;
	private static float	decelerationRateAP		= 0;
	private static float	rightTurnSpeed			= 0;
	private static float	decelerationRateSig		= 0;
	private static float	accelerationRate		= 0;
	private static float	bunchVehStreamHeadway	= 0;
	private static float	maxPlatoonHeadway		= 0;
	private static float	stopThreshSpeed			= 0;
	private static float	storedVehLaneLength		= 0;
	private static float	noOfCalcIterations		= 0;
	private static float	leftTurnBayLength		= 0;
	private static float	rightTurnEquivFactorSig	= 0;
	private static float	sneakersPerCycle		= 0;
	private static float	bsaeSaturationFlowRate	= 0;
	private static float	distBetnStoredVeh		= 0;
	private static float	leftTurnEquivFactor		= 0;
	private static float	majLeftCriticalHeadway	= 0;
	private static float	majLeftFollowupHeadway	= 0;
	private static float	rightTurnEquivFactorAP	= 0;

	private static JPanel	jPanel1;
	private static JPanel	jPanel2;
	private static JTable	table1;
	private static JTable	table2;

	/**
	 * 
	 */
	public static void createPanel()
	{
		urbanParaPanel = new JPanel();
		JPanel containerPanel = new JPanel();
		JLabel label = new JLabel("Enter your Urban Street Paramets here");
		Font font = new Font("Times New Roman", Font.BOLD, 15);
		label.setFont(font);
		urbanParaPanel.add(Box.createVerticalStrut(70));
		urbanParaPanel.add(label);
		jPanel1 = new JPanel();
		jPanel1.setLayout(new BorderLayout());
		jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(204, 204, 255), null, null));
		jPanel1.setPreferredSize(new Dimension(500, 440));

		jPanel2 = new JPanel();
		jPanel2.setLayout(new BorderLayout());
		jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED, null,
				new java.awt.Color(204, 204, 255), null, null));

		jPanel2.setPreferredSize(new Dimension(500, 440));

		addTable1();
		addTable2();

		containerPanel.add(jPanel1);
		containerPanel.add(jPanel2);
		urbanParaPanel.add(containerPanel);
		SetupWizard.addTab("URBAN STREET PARAMETERS", urbanParaPanel);

	}

	private static void addTable1()
	{
		// Create columns names
		String columnNames[] = { "label", "value" };

		Object[][] data = { { "Start-up lost time (l1), s", new Float(0.0) },
				{ "Extension of effective green, s", new Float(0.0) },
				{ "Analysis time period (T), h", new Float(0.0) },
				{ "Critical merge headway, s", new Float(0.0) },
				{ "Deceleration rate (access point), ft/s2", new Float(0.0) },
				{ "Right-turn speed (access point), ft/s", new Float(0.0) },
				{ "Deceleration rate (signal), ft/s2", new Float(0.0) },
				{ "Acceleration rate, ft/s2", new Float(0.0) },
				{ "Headway of bunched vehicle stream, s/veh", new Float(0.0) },
				{ "Maximum headway in a platoon, s/veh", new Float(0.0) },
				{ "Stop threshold speed, mph", new Float(0.0) } };

		// Create a new table instance
		final CustomCellRenderer renderer = new CustomCellRenderer("usp");
		DefaultTableModel model = new DefaultTableModel(data, columnNames)
		{
			public boolean isCellEditable(int row, int column)
			{
				if (column == 0)
				{
					return false;
				}
				return true;
			}
		};
		table1 = new JTable(model);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getColumnModel().getColumn(0).setPreferredWidth(300);
		table1.getColumnModel().getColumn(1).setPreferredWidth(75);
		table1.setRowHeight(40);
		table1.setRowSelectionAllowed(false);
		table1.setCellSelectionEnabled(false);
		table1.setDefaultRenderer(Object.class, renderer);
		table1.setGridColor(new Color(200,200,200));
		table1.setShowGrid(true);
		jPanel1.add(table1, BorderLayout.SOUTH);
	}

	private static void addTable2()
	{
		// Create columns names
		String columnNames[] = { "label", "value" };

		Object[][] data = {
				{ "Stored vehicle lane length, ft", new Float(0.0) },
				{ "Number of calculation iterations", new Float(0.0) },
				{ "Length of left-turn bay (access point), ft", new Float(0.0) },
				{ "Right-turn equivalency factor (signalized)", new Float(0.0) },
				{ "Sneakers per cycle, veh:", new Float(0.0) },
				{ "Base saturation flow rate, pc/h/ln", new Float(0.0) },
				{ "Distance between stored vehicles, ft", new Float(0.0) },
				{ "Left-turn equivalency factor (signalized)", new Float(0.0) },
				{ "Critical headway for major left (access pt.), s",
						new Float(0.0) },
				{ "Follow-up headway for major left (access pt.) ,s",
						new Float(0.0) },
				{ "Right-turn equivalency factor (access point)",
						new Float(0.0) } };

		// Create a new table instance
		final CustomCellRenderer renderer = new CustomCellRenderer("usp");
		DefaultTableModel model = new DefaultTableModel(data, columnNames)
		{
			public boolean isCellEditable(int row, int column)
			{
				if (column == 0)
				{
					return false;
				}
				return true;
			}
		};
		table2 = new JTable(model);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.getColumnModel().getColumn(0).setPreferredWidth(300);
		table2.getColumnModel().getColumn(1).setPreferredWidth(75);
		table2.setRowHeight(40);
		table2.setRowSelectionAllowed(false);
		table2.setCellSelectionEnabled(false);
		table2.setDefaultRenderer(Object.class, renderer);
		table2.setGridColor(new Color(200,200,200));
		table2.setShowGrid(true);
		jPanel2.add(table2, BorderLayout.SOUTH);
		
	}

	public static boolean storeData()
	{
		if (table1.isEditing())
		    table1.getCellEditor().stopCellEditing();
		if (table2.isEditing())
		    table2.getCellEditor().stopCellEditing();
		try
		{
			startupLostTime = getCellValue(table1, 0);
			effGreeExtn = getCellValue(table1, 1);
			analysisTimePeriod = getCellValue(table1, 2);
			criticalMergeHeadway = getCellValue(table1, 3);
			decelerationRateAP = getCellValue(table1, 4);
			rightTurnSpeed = getCellValue(table1, 5);
			decelerationRateSig = getCellValue(table1, 6);
			accelerationRate = getCellValue(table1, 7);
			bunchVehStreamHeadway = getCellValue(table1, 8);
			maxPlatoonHeadway = getCellValue(table1, 9);
			stopThreshSpeed = getCellValue(table1, 10);
			storedVehLaneLength = getCellValue(table2, 0);
			noOfCalcIterations = getCellValue(table2, 1);
			leftTurnBayLength = getCellValue(table2, 2);
			rightTurnEquivFactorSig = getCellValue(table2, 3);
			sneakersPerCycle = getCellValue(table2, 4);
			bsaeSaturationFlowRate = getCellValue(table2, 5);
			distBetnStoredVeh = getCellValue(table2, 6);
			leftTurnEquivFactor = getCellValue(table2, 7);
			majLeftCriticalHeadway = getCellValue(table2, 8);
			majLeftFollowupHeadway = getCellValue(table2, 9);
			rightTurnEquivFactorAP = getCellValue(table2, 10);
		}
		catch (ClassCastException e)
		{
			JOptionPane.showMessageDialog(urbanParaPanel,
					"Please check your entered values", "Error in value",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(urbanParaPanel,
					"Please check your entered values", "Error in value",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private static float getCellValue(JTable table, int row)
	{
		Object value = table.getModel().getValueAt(row, 1);
		if (value instanceof String)
		{
			float val = Float.parseFloat((String) value);
			return val;
		}
		return 0;
	}

}
