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
* @since <pre>���� 27, 2016</pre> 
* @version 1.0 
*/ 
public class ReadListTest { 

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
* Method: GetTotal() 
* 
*/ 
@Test
public void testGetTotal() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/1234.txt";
    String arg2="fixture/123.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    System.out.println(rd.GetTotal());
} 

/** 
* 
* Method: GetSave() 
* 
*/ 
@Test
public void testGetSave() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/1234.txt";
    String arg2="fixture/123.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    System.out.println(rd.GetSave());
} 

/** 
* 
* Method: Display() 
* 
*/ 
@Test
public void testDisplay() throws Exception { 
//TODO: Test goes here...
    String arg1="fixture/1234.txt";
    String arg2="fixture/123.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    rd.Display();
}

@Test
public void testGetCorrectReadListWithOneSingleItem() throws Exception{
    String arg1="fixture/OneSingle.txt";
    String arg2="fixture/OneSingleItemIme.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    String expectedShoppingList =
            "***商店购物清单***\n"
                    + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                    + "----------------------\n"
                    + "总计:3.00(元)\n"
                    + "**********************\n";
    assertThat(rd.GetDisplay(), is(expectedShoppingList));
}

    @Test
    public void testGetCorrectReadListWithTwoSameItem() throws Exception{
        String arg1="fixture/TwoSame.txt";
        String arg2="fixture/TwoSameItemIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectReadListWithTwoDifferentItem() throws Exception{
        String arg1="fixture/TwoDifferent.txt";
        String arg2="fixture/TwoDifferentItemIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        // then
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
    public void testGetCorrectReadListWithThreeItemsInTwoDifferentItem() throws Exception{
        String arg1="fixture/TwoDifferent.txt";
        String arg2="fixture/TwoDifferentItemImeWithThreeItems.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "名称:雪碧,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "----------------------\n"
                        + "总计:9.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectReadListWithFourItemsInTwoDifferentItem() throws Exception{
        String arg1="fixture/TwoDifferent.txt";
        String arg2="fixture/TwoDifferentItemImeWithFourItems.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "名称:雪碧,数量:2瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "总计:12.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListWhenDifferentItemHaveSameItemName() throws  Exception{
        String arg1="fixture/TwoDifferentItemWithSameName.txt";
        String arg2="fixture/TwoDifferentItemWithSameNameIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "名称:可口可乐,数量:1瓶,单价:2.00(元),小计:2.00(元)\n"
                        + "----------------------\n"
                        + "总计:5.00(元)\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListThreeSameItem() throws Exception{
        String arg1="fixture/OneSingle.txt";
        String arg2="fixture/ThreeSameItemIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:可口可乐,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.0元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListSixDifferentItemInTwoItemImes() throws Exception{
        String arg1="fixture/TwoDifferent.txt";
        String arg2="fixture/SixDifferentItemIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "名称:雪碧,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:可口可乐,数量:1瓶\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:雪碧,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:12.00(元)\n"
                        + "节省:6.0元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }
}
