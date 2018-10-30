package com.sj.atls;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * Reimplement this code so that its results will always be the same, 
 * but that it does not cause a stack overflow on large inputs. 
 * Your solution must still implement the Folder interface.



 */
public class MyFolder <T, U> implements Folder <T, U>{

    public static void main(String[] args) {

        Folder<Integer,Integer> folder = new MyFolder<Integer, Integer>();

        Queue<Integer> q = new LinkedList<Integer>();

        for(int lop =0; lop < 1000000; lop++ ){ //add some values in the Queue
            q.add(lop);
        }
        Integer result = folder.fold(0, q, new Function2<Integer, Integer, Integer>() {
            public Integer apply(Integer val1, Integer val2) {
                return val1 + val2;
            }
        });

        System.out.println("Result: " + result);
    }
    
    
    public U fold(U u, Queue<T> ts, Function2<T, U, U> fun) {

        if(u == null || ts == null || fun == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

      //get an iterator first instead of forEach loop, because poll() is modifying underlying collection/queue
        Iterator<T> iter = ts.iterator(); 
        while (iter.hasNext()) { //loop over the items

            u = fun.apply( ts.poll() , u); 

        } 

        return u;
    } 
	
    
	public U fold3(U u, Queue<T> ts, Function2<T, U, U> function){
		

		
// The base point of recursion.
		if(ts.isEmpty()){
			return u;
		}
		
		return fold3(function.apply(ts.poll(), u), ts, function);
//		Tail recursion.
		
/*		U res = function.apply(ts.poll(),u);
		while(!ts.isEmpty())
		{
			function.apply(ts.poll(),u);
		}
		return res;*/
	}
	
	
	public U fold2(U u, Queue<T> ts, Function2<T, U, U> function){
		
		if(u == null || ts == null || function == null)
			throw new IllegalArgumentException();
		
// The base point of recursion.
//		if(ts.isEmpty()){
//			return u;
//		}
		
//		return fold(function.apply(ts.poll(), u), ts, function);
//		Tail recursion.
		
		U res = function.apply(ts.poll(),u);
		while(!ts.isEmpty())
		{
			function.apply(ts.poll(),u);
		}
		return res;
	}

}