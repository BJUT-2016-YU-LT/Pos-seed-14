package test.com.company;

import com.company.Item;
import com.company.ItemList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ItemList Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2016</pre> 
* @version 1.0 
*/ 
public class ItemListTest { 

@Before
public void before() throws Exception {
    System.out.println("before");
} 

@After
public void after() throws Exception {
    System.out.println("after");
} 

/** 
* 
* Method: SubTotal() 
* 
*/ 
@Test
public void testSubTotal() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/1.txt";
    ItemList a=new ItemList(arg1);
    System.out.println(a.SubTotal());
} 

/** 
* 
* Method: Save() 
* 
*/ 
@Test
public void testSave() throws Exception {
//TODO: Test goes here...
    String arg1="fixture/1.txt";
    ItemList a=new ItemList(arg1);
    System.out.println(a.Save());
} 


} 
