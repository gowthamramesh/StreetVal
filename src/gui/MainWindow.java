/**
 * StreetVal MainFrame
 * Entry point to the code
 * Author : ITRE - NC State Department
 * Date   : 12/11/2014 
 */

package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 * MainFrame of the StreetVal software
 * 
 * @author Gowtham Ramesh
 */
public class MainWindow extends JFrame
{
	// Variables declaration
	private static final long		serialVersionUID	= 1L;
	private BufferedImage			image;
	private javax.swing.JPanel		actionPanel;
	private javax.swing.JMenu		jMenu1;
	private javax.swing.JMenu		jMenu2;
	private javax.swing.JMenuBar	jMenuBar1;
	private javax.swing.JPanel		jPanel1;
	private javax.swing.JPanel		jPanel2;
	private javax.swing.JToolBar	jToolBar1;
	private static MainWindow		mainFrame			= null;

	// End of variables declaration

	/**
	 * Creates new form MainWindow
	 * 
	 * @throws IOException
	 */
	public MainWindow() throws IOException
	{
		this.setTitle("Urban StreetVal Computation - ITRE NCSU");
		this.setIconImage(new ImageIcon(
				"C:\\Users\\LENOVO\\Downloads\\icon.png").getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		initComponents();
	}

	/**
	 * This method initializes the Main Frame of StreetVal
	 * 
	 * @throws IOException
	 */
	private void initComponents() throws IOException
	{

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		image = ImageIO
				.read(new File("C:\\Users\\LENOVO\\Downloads\\gear.png"));
		actionPanel = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null); // see javadoc for more info on
												// the parameters
			}
		};
		Border raisedBorder = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		actionPanel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				actionPanel.setBorder(raisedBorder);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				actionPanel.setBorder(loweredbevel);

			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				SetupWizard.showsetUpWizDialog(mainFrame);

			}
		});

		jToolBar1 = new javax.swing.JToolBar();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(
				actionPanel);
		actionPanel.setLayout(actionPanelLayout);
		actionPanel.setBorder(raisedBorder);
		actionPanelLayout.setHorizontalGroup(actionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 39, Short.MAX_VALUE));
		actionPanelLayout.setVerticalGroup(actionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 40, Short.MAX_VALUE));

		jToolBar1.setRollover(true);
		jToolBar1.setAlignmentX(0.0F);
		jToolBar1.setBackground(new Color(225, 225, 255));
		jPanel1.setBackground(new Color(240, 240, 255));
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addComponent(actionPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jToolBar1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 703,
								Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																actionPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jToolBar1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																45,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE)));

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		jPanel2.setBackground(new Color(225, 225, 255));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 647,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(397, Short.MAX_VALUE)
						.addComponent(jPanel2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}

	public static MainWindow getMainFrame()
	{
		return mainFrame;
	}

	/**
	 * Main class of the Streetval
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		// Setting the Look and feel for StreetVal
		try
		{
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}

		// Create mainFrame in EDT thread
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					mainFrame = new MainWindow();
					mainFrame.setVisible(true);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}
