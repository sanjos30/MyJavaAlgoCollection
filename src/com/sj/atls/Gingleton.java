package com.sj.atls;

public class Gingleton {
    private static Gingleton INSTANCE = null;

    public static Gingleton getInstance()
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new Gingleton();
        }
        return INSTANCE;
    }

    private Gingleton() {
    	System.out.println("Gingleton");
    }
    
    public static void main(String[] args) {
    	while(true)
		getInstance();
	}
}
