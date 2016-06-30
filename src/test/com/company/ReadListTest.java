package test.com.company; 

import com.company.ItemList;
import com.company.Pos;
import com.company.ReadList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/** 
* ReadList Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 30, 2016</pre> 
* @version 1.0 
*/ 
public class ReadListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: GetTotal() 
* 
*/ 
@Test
public void testGetTotal() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/123.txt";
    Pos p=new Pos(arg1);
    ReadList rd=new ReadList(p);
    double total=22.60;
    assertThat(rd.GetTotal(), is(total));
} 

/** 
* 
* Method: GetSave() 
* 
*/ 
@Test
public void testGetSave() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/123.txt";
    Pos p=new Pos(arg1);
    ReadList rd=new ReadList(p);
    double rdr=rd.GetSave();
    double save=0.4+1-1;
    assertThat(rd.GetSave(), is(save));
} 

/** 
* 
* Method: GetDisplay() 
* 
*/

@Test
public void testDisplay(){
    String arg1="fixture/123.txt";
    Pos p=new Pos(arg1);
    ReadList rd=new ReadList(p);
    String expectedShoppingList =
            "***商店购物清单***\n"
                    + "名称:可口可乐,数量:5瓶,单价:3.00(元),小计:15.00(元)\n"
                    + "名称:雪碧,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                    + "----------------------\n"
                    + "总计:21.00(元)\n"
                    + "**********************\n";
    assertThat(rd.GetDisplay(), is(expectedShoppingList));
}

@Test
public void testGetCorrectShoppingListWithOneItem() throws Exception {
//TODO: Test goes here...
    String arg1="fixture/OneItem.txt";
    Pos p=new Pos(arg1);
    ReadList rd=new ReadList(p);
    String expectedShoppingList =
            "***商店购物清单***\n"
                    + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                    + "----------------------\n"
                    + "总计:3.00(元)\n"
                    + "**********************\n";
    assertThat(rd.GetDisplay(), is(expectedShoppingList));
}

    @Test
    public void testGetCorrectShoppingListWithTwoItem() throws Exception {
//TODO: Test goes here...
        String arg1="fixture/TwoItem.txt";
        Pos p=new Pos(arg1);
        ReadList rd=new ReadList(p);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListWithTwoDifferentItem() throws Exception {
//TODO: Test goes here...
        String arg1="fixture/TwoDifferentItem.txt";
        Pos p=new Pos(arg1);
        ReadList rd=new ReadList(p);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "名称:雪碧,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListWithOneItemWithDiscount() throws Exception {
//TODO: Test goes here...
        String arg1="fixture/OneItemWithDiscount.txt";
        Pos p=new Pos(arg1);
        ReadList rd=new ReadList(p);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:电池,数量:1个,单价:2.00(元),小计:1.60(元)\n"
                        + "----------------------\n"
                        + "总计:1.60(元)\n"
                        + "节省:0.40元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListWithTwoItemWithDiscount() throws Exception {
//TODO: Test goes here...
        String arg1="fixture/TwoItemWithDiscount.txt";
        Pos p=new Pos(arg1);
        ReadList rd=new ReadList(p);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:电池,数量:2个,单价:2.00(元),小计:3.20(元)\n"
                        + "----------------------\n"
                        + "总计:3.20(元)\n"
                        + "节省:0.80元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListWithTwoItemWithOneDiscount() throws Exception {
//TODO: Test goes here...
        String arg1="fixture/TwoItemWithOneDiscount.txt";
        Pos p=new Pos(arg1);
        ReadList rd=new ReadList(p);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:电池,数量:1个,单价:2.00(元),小计:1.60(元)\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "----------------------\n"
                        + "总计:4.60(元)\n"
                        + "节省:0.40元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }
} 
