/**
 * @author Gowtham Ramesh
 * @Date 12-Dec-2014
 */
package information;

import java.util.ArrayList;

public class ODSpeedProportion
{
	/*
	 * The Array list elements of upStreamOrigin represent the following: Cross
	 * St. Left Turn Major St.Through Cross St.Right Turn Mid-Seg. Entry
	 */
	// Each arraylist contains one entire downstream origin row values
	private static ArrayList<ArrayList<Float>>	upStreamOrigin		= new ArrayList<ArrayList<Float>>();

	/*
	 * donwStreamOrigin row values corresponds to the following: Left Turn
	 * Through Right Turn Mid-Segment Exit
	 */
	private static ArrayList<Float>				downStreamOrigin	= new ArrayList<Float>();

	/**
	 * 
	 */
	public static void createPanel()
	{
		// TODO Auto-generated method stub
		
	}

	public static boolean storeData()
	{
		return true;
		
	}
}
