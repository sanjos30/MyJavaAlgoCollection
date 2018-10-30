package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.List;

public class FindArrayInAnotherArray {

	public static void main(String[] args) {
		
		
		int[] arr = { 1,3,5,7,4,6,5,7};
		 
		int[] subArr= {5,7};
		
		System.out.println(findArray(arr,subArr));

	}

	public static int findArray(int[] array, int[] subArray){
		//Error possible of an array.
		if (array == null || subArray == null || subArray.length > array.length)
        {
            return -1;
        }
		int index = -1; // assume not found
		
		List<Integer> indList=new ArrayList<Integer>();
        
        for (int i = 0; i < array.length; i++)
        {
            // Check if the next element of array is same as the first element of subarray
            if (array[i] == subArray[0])
            {
                //check subsequent elements of subarray against the subsequent elements of array
                for (int j = 0; j < subArray.length; j++)
                {
                    //if found, set the index
                    if (i + j < array.length && subArray[j] == array[i + j])
                    {
                        index = i;
                        	if(!indList.contains(index))
                        		indList.add(index);
                    }
                    else
                    {
                        index = -1;
                        break;
                    }
                }
            }
        }
        
        for(int a:indList)
        	System.out.println(a);
        return index;
    }

}
