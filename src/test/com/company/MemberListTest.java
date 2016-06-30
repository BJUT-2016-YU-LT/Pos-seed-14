package test.com.company; 

import com.company.MemberList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MemberList Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 29, 2016</pre> 
* @version 1.0 
*/ 
public class MemberListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

    @Test
    public void testInput(){
        MemberList m=new MemberList("fixture3/Member.txt");
        System.out.print("*****");
    }

} 
