import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Foo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

//        for (int i = 0; i < list.size(); i++) {
//            list.add(list.get(i) + "tadam");
//        }

        for(String s : list){
            list.add( "tadam");
        }

        System.out.println(list);
    }


}