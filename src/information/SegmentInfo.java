package information;

import java.util.ArrayList;

/**
 * This class contains the basic segment information
 * 
 * @author Gowtham Ramesh
 *
 */
public class SegmentInfo
{
	private static ArrayList<SegmentInfo>	segmentData			= new ArrayList<SegmentInfo>();
	private int								segmentNo			= 1;
	private float							ebSpeedLimit		= 0;
	private float							wbSpeedLimit		= 0;
	private float							ebThroughLanes		= 0;
	private float							wbThroughLanes		= 0;
	private float							segmentLength		= 0;
	private int								noOfIntersections	= 0;

	public SegmentInfo(int no, float ebSpdLim, float wbSpdLim,
			float ebThruLane, float wbThruLane, float segLen, int intCount)
	{
		segmentNo = no;
		ebSpeedLimit = ebSpdLim;
		wbSpeedLimit = wbSpdLim;
		ebThroughLanes = ebThruLane;
		wbThroughLanes = wbThruLane;
		segmentLength = segLen;
		noOfIntersections = intCount;
	}

	public static ArrayList getSegmentData()
	{
		return segmentData;
	}

	public static void addSegmentDataObj(SegmentInfo info)
	{
		segmentData.add(info);
	}

}
