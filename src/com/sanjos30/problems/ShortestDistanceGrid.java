package com.sanjos30.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceGrid {
	
	public static void main(String args[]) {
		
        char[][] matrix = {
                {'1', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '9'},
                {'0', '1', '1', '0'}
            };
            
       System.out.println(findShortestPathBFS(matrix,0,0));
	}

	private static int findShortestPathBFS(char arr[][], int startX, int startY)
	{
		if(arr[startX][startY]=='9') return 0;
		
		/**
		 * 			arr[i][j+1]	 	right
					arr[i][j-1] 	left
					arr[i+1][j] 	down									
					arr[i-1][j]		up
		 */
		int moveX[]=new int[]{0,0,1,-1}; //right,left,down & up
		int moveY[]=new int[]{1,-1,0,0}; //right,left,down & up
		boolean visited[][]=new boolean[arr.length][arr[0].length];
		Queue<QNode> qNodes = new LinkedList<>();
		qNodes.add(new QNode(startX,startY,0));
		while(!qNodes.isEmpty())
		{
			QNode currNode=qNodes.remove();
			int currX=currNode.x;
			int currY=currNode.y;
			int currDistance = currNode.distance;
			visited[currX][currY]=true;
			//System.out.println(arr[currX][currY]);
			
			//If current elem is 9, then return the distance from the Node object.
			if(arr[currX][currY]=='9') return currDistance;
			
			//else move right, left, up & down to find any 1 i.e. any non-zero and movable cells
			for (int i = 0; i < moveX.length; i++) 
			{
				int newX=currX+moveX[i];
				int newY=currY+moveY[i];
				//System.out.println("Scanning pattern is:");
				System.out.print("("+newX + ","+newY+")" );
				if(newX>=0&&newX<arr.length&&newY>=0&&newY<arr[0].length&&!visited[newX][newY]&&arr[newX][newY]!='0')
				{
					qNodes.add(new QNode(newX,newY,currDistance+1));
				}
			}
				
			
		}
		
		return -1;
	}	
}

class QNode
	{
		int x;
		int y;
		int distance;
		QNode(int x,int y, int distance)
		{
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
}

