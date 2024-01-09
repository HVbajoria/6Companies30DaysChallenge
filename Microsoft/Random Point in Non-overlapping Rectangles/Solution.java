class Solution 
{
	protected int[][] units;
	protected int totalSum = 0;
	protected Random rand = new Random();

	public Solution(int[][] rects) 
	{
		units = rects;

		for (int[] theRec: rects)
		{    
			totalSum += (theRec[2] - theRec[0] + 1) * (theRec[3] - theRec[1] + 1);
			theRec[3] = totalSum;
		}

		++totalSum; 
	}

	protected int bisect_left(int target)
	{     
		int left = 0, right = units.length, mid;

		while (left < right)
		{         
			mid = (left + right) >> 1;  

			if (units[mid][3] < target)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}

	public int[] pick() 
	{
		int rnd = rand.nextInt(1, totalSum);
		int indx = bisect_left(rnd);
		int[] theUnit = units[indx];

		int a = rnd - (indx != 0 ? units[indx - 1][3] : 0) - 1;
		int b = theUnit[2] - theUnit[0] + 1;

		return new int[]
		{
			theUnit[0] + a % b,
			theUnit[1] + a / b
		};
	}
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
 
