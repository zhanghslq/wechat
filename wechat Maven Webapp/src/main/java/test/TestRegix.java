package test;

public class TestRegix {
    public static void main(String[] args) {
        String s="undefined:undefined";
        if(s.indexOf("undefined")!=-1){//包含
            String undefined = s.replaceAll("undefined", "1");
            System.out.println(undefined);
        }else {
            System.out.println("buhan");
        }



    }
}
