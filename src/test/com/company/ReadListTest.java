package test.com.company; 

import com.company.ItemList;
import com.company.MemberList;
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
    String arg1="fixture/1234.txt";
    String arg2="fixture/123.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    double total=19.6;
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
    String arg1="fixture/1234.txt";
    String arg2="fixture/123.txt";
    ItemList s=new ItemList(arg1);
    Pos p=new Pos(arg2);
    ReadList rd=new ReadList(p,s);
    System.out.println(rd.GetSave());
    double save=3.4;
    assertThat(rd.GetSave(), is(save));
} 

/** 
* 
* Method: GetDisplay()
* 
*/

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
                        + "节省:3.00元\n"
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
                        + "节省:6.00元\n"
                        + "**********************\n";
        assertThat(rd.GetDisplay(), is(expectedShoppingList));
    }


    //第三阶段需求5
    @Test
    public void testGetCorrectShoppingListOneItemWithVipDiscountWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime1.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:0\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:2.70(元)\n"
                        + "----------------------\n"
                        + "总计:2.70(元)\n"
                        + "节省:0.30元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }


    @Test
    public void testGetCorrectShoppingListTwoItemTwoSameItemWithVipDiscountWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime2.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:1\n"
                        + "名称:可口可乐,数量:2瓶,单价:3.00(元),小计:5.40(元)\n"
                        + "----------------------\n"
                        + "总计:5.40(元)\n"
                        + "节省:0.60元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListTwoItemTwoDifferentItemWithDiscountWithVipDiscountWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime3.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:0\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:2.70(元)\n"
                        + "名称:雪碧,数量:1瓶,单价:3.00(元),小计:2.28(元)\n"
                        + "----------------------\n"
                        + "总计:4.98(元)\n"
                        + "节省:1.02元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListThreeItemTwoSameItemWithDiscountWithVipDiscountWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime4.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:1\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:2.70(元)\n"
                        + "名称:雪碧,数量:2瓶,单价:3.00(元),小计:4.56(元)\n"
                        + "----------------------\n"
                        + "总计:7.26(元)\n"
                        + "节省:1.74元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListThreeItemOneItemWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime5.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:3\n"
                        + "名称:电池,数量:3个,单价:5.00(元),小计:15.00(元)\n"
                        + "----------------------\n"
                        + "总计:15.00(元)\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListOneItemOneItemWithVipDiscountWithNotMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime6.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:可口可乐,数量:1瓶,单价:3.00(元),小计:3.00(元)\n"
                        + "----------------------\n"
                        + "总计:3.00(元)\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListThreeItemOneItemWithDiscountWithVipDiscountWithNotMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime7.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:雪碧,数量:1瓶,单价:3.00(元),小计:2.40(元)\n"
                        + "名称:电池,数量:2个,单价:5.00(元),小计:10.00(元)\n"
                        + "----------------------\n"
                        + "总计:12.40(元)\n"
                        + "节省:0.60元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test               //Promotion测试
    public void testGetCorrectShoppingListThreeItemOneItemWithPromotionWithMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime8.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER001    会员积分:1\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListThreeItemOneItemWithPromotionWithNotMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime9.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test       //需求6
    public void testAddIntegralWith0() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime10.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER004    会员积分:1\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testAddIntegralWith200() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime11.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER005    会员积分:201\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testAddIntegralWith201() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime12.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER006    会员积分:204\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testAddIntegralWith500() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime13.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER007    会员积分:503\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testAddIntegralWith501() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime14.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号:USER008    会员积分:506\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }

    @Test
    public void testIsAddIntegralWithNotMember() throws Exception{
        String arg1="fixture3/Member.txt";
        String arg2="fixture3/ThreeItem.txt";
        String arg3="fixture3/Ime15.txt";
        MemberList memberList=new MemberList(arg1);
        ItemList itemList=new ItemList(arg2);
        Pos pos=new Pos(arg3);
        ReadList readList=new ReadList(pos,itemList,memberList);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称:芬达,数量:3瓶,单价:3.00(元),小计:6.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:芬达,数量:1瓶\n"
                        + "----------------------\n"
                        + "总计:6.00(元)\n"
                        + "节省:3.00元\n"
                        + "**********************\n";
        assertThat(readList.GetDisplay(), is(expectedShoppingList));
    }
}
