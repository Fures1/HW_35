package core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.*;
import java.io.*;
import java.util.*;

public  class DPCSVTest {
    String csvFile="/Users/Seyran/Workspace/alexAcademy/Java/Homework/HW_35/src/test/java/core/input.csv";

    @DataProvider(name = "data")
    public Iterator<String[]> data_provider() throws IOException {
        String csvLine="";
        String[] a=null;
        ArrayList<String[]> al=new ArrayList<String[]>();
        BufferedReader br=new BufferedReader(new FileReader(csvFile));
        while ((csvLine=br.readLine()) !=null){
            a=csvLine.split(",");
            al.add(a);
        }
        br.close();
        return al.iterator();
    }

    @Test(dataProvider = "data")
    public static void test(String a, String b, String c, String d){
        System.out.println(a+", "+b+", "+c+", "+d);
        assertThat(Integer.parseInt(b)+Integer.parseInt(c),is(Integer.parseInt(d)));
    }
}
