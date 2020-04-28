import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaPlay {

    public static void main(String[] args) {
        List<String> mylist = new ArrayList<String>();
        mylist.add("practice");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        System.out.println("Original List : " + mylist);
        List<String> mylist2 = mylist;
        System.out.println("copied List : " + mylist2);
        // Here we are using rotate() method
        // to rotate the element by distance 2
        Collections.rotate(mylist, -2);

        //System.out.println("Rotated List: " + mylist);

    }
}
