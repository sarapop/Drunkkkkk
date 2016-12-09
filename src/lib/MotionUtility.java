package lib;

public class MotionUtility {

	public static int[] linearMotion(int x,int startY,int endY,
			int screenHeight,int currentY){
		int[] currentPos = new int[2];
		currentPos[0] = x;
		currentPos[1] = startY+(endY-startY)*currentY/screenHeight;
		return currentPos;
	}

}
