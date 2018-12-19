public class PatternDesign {

    public static void main(String args[]){
        String start = "a";
        System.out.print("运行");
        matchStr(start);
    }

    public static void matchStr(String str){
        if ("c".equals(str)){
            System.out.print("ccc");
        }else if ("d".equals(str)){
            System.out.print("ddd");
        }else if ("a".equals(str)){
            System.out.print("aaa");
        }
    }

}
