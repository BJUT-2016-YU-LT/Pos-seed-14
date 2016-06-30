package test.com.company; 

import com.company.Item;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Item Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2016</pre> 
* @version 1.0 
*/ 
public class ItemTest { 

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
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getName());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getName());
} 

/** 
* 
* Method: getUnit() 
* 
*/ 
@Test
public void testGetUnit() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getUnit());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getUnit());
} 

/** 
* 
* Method: getPrice() 
* 
*/ 
@Test
public void testGetPrice() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getPrice());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getPrice());
} 

/** 
* 
* Method: getBarcode() 
* 
*/ 
@Test
public void testGetBarcode() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getBarcode());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getBarcode());
}

/** 
* 
* Method: getDiscount() 
* 
*/ 
@Test
public void testGetDiscount() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getDiscount());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getDiscount());
} 

/** 
* 
* Method: getPromotion() 
* 
*/ 
@Test
public void testGetPromotion() throws Exception { 
//TODO: Test goes here...
    Item it1=new Item("ITEM000000","可口可乐","瓶",3.00,0.8);
    System.out.println(it1.getPromotion());
    Item it2=new Item("ITEM000000","可口可乐","瓶",3.00,true);
    System.out.println(it2.getPromotion());
} 

/** 
* 
* Method: setBarcode(String barcode) 
* 
*/ 
@Test
public void testSetBarcode() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setBarcode("ITEM000000");
    System.out.println(it.getBarcode());
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setName("可口可乐");
} 

/** 
* 
* Method: setUnit(String unit) 
* 
*/ 
@Test
public void testSetUnit() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setUnit("瓶");
} 

/** 
* 
* Method: setPrice(double price) 
* 
*/ 
@Test
public void testSetPrice() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setPrice(3.00);
} 

/** 
* 
* Method: setDiscount(double discount) 
* 
*/ 
@Test
public void testSetDiscount() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setDiscount(0.8);
} 

/** 
* 
* Method: setPromotion(boolean promotion) 
* 
*/ 
@Test
public void testSetPromotion() throws Exception { 
//TODO: Test goes here...
    Item it=new Item();
    it.setPromotion(true);
} 


} 
