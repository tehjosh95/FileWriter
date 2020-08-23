package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import ForTesting.*;  
  
public class TestUnit {  
  
    @Test 
    public void testUniqueLines(){
    	int x = 200;
        assertEquals(x,Main.driver(Integer.valueOf(200))); 
    }  
    
    @Test 
    public void testOutOfRange1(){  
    	int x = 0;
        assertEquals(0,Main.driver(Integer.valueOf(x))); 
    } 
    
    @Test 
    public void testOutOfRange2(){  
    	int x = 300;
        assertEquals(0,Main.driver(Integer.valueOf(x))); 
    } 
    
}  