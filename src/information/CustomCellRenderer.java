package information;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomCellRenderer extends DefaultTableCellRenderer
{
	String	tablename	= "usp";

	public CustomCellRenderer(String tname)
	{
		tablename = tname;
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{

		Component rendererComp = super.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);

		if ((tablename == "usp" && column == 0)
				|| (tablename == "segment" && (column == 0 || column == 1 || column == 2)))
		{
			rendererComp.setBackground(new Color(222, 222, 222));
			rendererComp.setForeground(Color.black);
		}
		else
		{
			rendererComp.setBackground(null);
			rendererComp.setForeground(Color.black);
			if (value instanceof String)
			{
				try
				{
					Float.parseFloat((String) value);
				}
				catch (NumberFormatException e)
				{
					rendererComp.setForeground(Color.RED);
				}
			}
		}
		return rendererComp;
	}
}
