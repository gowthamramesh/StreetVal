package information;

import gui.SetupWizard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SegmentInfoPanel
{
	private static JPanel	segInfoPanel;
	private static JPanel	jPanel1;
	private static JTable	table1;

	public static void createPanel()
	{
		segInfoPanel = new JPanel();
		segInfoPanel.setLayout(null);
		segInfoPanel.setPreferredSize(new Dimension(900,800));
		JPanel containerPanel = new JPanel();
		
		Font font = new Font("Times New Roman", Font.BOLD, 15);
		JLabel label1 = new JLabel("Cross Street Names");
		Font font1 = new Font("Times New Roman", Font.BOLD, 12);
		JLabel label2 = new JLabel("Speed Limit, mph");
		JLabel label3 = new JLabel("Through Lanes");
		label1.setFont(font);
		label2.setFont(font1);
		label3.setFont(font1);
		
		segInfoPanel.add(Box.createVerticalStrut(70));
		jPanel1 = new JPanel();
		jPanel1.setLayout(new BorderLayout());
		jPanel1.setPreferredSize(new Dimension(710, 450));

		label1.setBounds(10, 10, 100, 20);

		addTable1();

		JPanel labelPanel = new JPanel();
		labelPanel.add(Box.createHorizontalStrut(120));
		labelPanel.add(label1);
		labelPanel.add(Box.createHorizontalStrut(120));
		labelPanel.add(label2);
		labelPanel.add(label3);
		containerPanel.add(labelPanel);
		containerPanel.add(jPanel1);
		containerPanel.setBounds(150, 50, 800, 390);
		segInfoPanel.add(containerPanel);
		SetupWizard.addTab("URBAN STREET PARAMETERS", segInfoPanel);

	}

	private static void addTable1()
	{
		String columnNames[] = { "SEGMENT NO", "STREET TO WEST", "STREET TO EAST",
				"EB", "EB", "EB", "WB", "SEGMENT LENGTH" };

		Object[][] data = {
				{"1","First Avenue","Second Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"2","Second Avenue","Third Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"3","Third Avenue","Fourth Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"4","Fourth Avenue","Fifth Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"5","Fifth Avenue","Sixth Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"6","Sixth Avenue","Seventh Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"7","Seventh Avenue","Eighth Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				{"8","Eighth Avenue","Ninth Avenue", new Float(0.0) , new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.0)},
				
		};

		// Create a new table instance
		final CustomCellRenderer renderer = new CustomCellRenderer("segment");
		DefaultTableModel model = new DefaultTableModel(data, columnNames)
		{
			public boolean isCellEditable(int row, int column)
			{
				if (column == 0 || column == 1 || column == 2)
				{
					return false;
				}
				return true;
			}
		};
		table1 = new JTable(model);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getColumnModel().getColumn(0).setPreferredWidth(52);
		table1.getColumnModel().getColumn(1).setPreferredWidth(200);
		table1.getColumnModel().getColumn(2).setPreferredWidth(200);
		table1.getColumnModel().getColumn(3).setPreferredWidth(50);
		table1.getColumnModel().getColumn(4).setPreferredWidth(50);
		table1.getColumnModel().getColumn(5).setPreferredWidth(50);
		table1.getColumnModel().getColumn(6).setPreferredWidth(50);
		table1.getColumnModel().getColumn(7).setPreferredWidth(50);
		table1.setRowHeight(40);
		table1.setRowSelectionAllowed(false);
		table1.setCellSelectionEnabled(false);
		table1.getTableHeader().setResizingAllowed(false);
		table1.getTableHeader().addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent evt)
			{
				JTableHeader header = (JTableHeader) evt.getSource();
				TableColumnModel colModel = table1.getColumnModel();
				int vColIndex = colModel.getColumnIndexAtX(evt.getX());
				if (vColIndex >= 0)
					header.setToolTipText(columnNames[vColIndex]);
			}
		});
		table1.setDefaultRenderer(Object.class, renderer);
		table1.setGridColor(new Color(200,200,200));
		table1.setShowGrid(true);
		jPanel1.add(new JScrollPane(table1), BorderLayout.SOUTH);
	}


	public static boolean storeData()
	{
		if (table1.isEditing())
		    table1.getCellEditor().stopCellEditing();
		try
		{
			/*startupLostTime = getCellValue(table1, 0);
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
			rightTurnEquivFactorAP = getCellValue(table2, 10);*/
		}
		catch (ClassCastException e)
		{
			JOptionPane.showMessageDialog(segInfoPanel,
					"Please check your entered values", "Error in value",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(segInfoPanel,
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
