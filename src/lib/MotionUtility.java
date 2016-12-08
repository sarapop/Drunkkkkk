package lib;

public class MotionUtility {

	public static int[] linearMotion(int startX,int startY,int endX,int endY,
			int duration,int currentTick){
		int[] currentPos = new int[2];
		currentPos[0] = startX+(endX-startX)*currentTick/duration;
		currentPos[1] = startY+(endY-startY)*currentTick/duration;
		return currentPos;
	}

}
