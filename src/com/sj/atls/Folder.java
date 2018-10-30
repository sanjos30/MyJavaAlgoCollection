package com.sj.atls;
/**
 * 
 * Reimplement this code so that its results will always be the same, 
 * but that it does not cause a stack overflow on large inputs. 
 * Your solution must still implement the Folder interface.



 */
import java.util.List;
import java.util.Queue;

public interface Folder<T, U>
{
    U fold(U u, Queue<T> list, Function2<T,U,U> function);
}
