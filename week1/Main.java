import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   public static void  main(String[] args) {
       System.out.println("--------商品查询部分-----------");
        Commodity[] shop = {
                new Commodity("HW01", "01","HW",3000.0, 14.0, 10),
                new Commodity("LX01", "02", "LX",3500.0,14.0, 6),
                new Commodity("HS01", "03", "HS",4000.0,14.0, 8),
                new Commodity("MC01", "04", "MC",4000.0,12.0, 9),
                new Commodity("HP01", "05", "HP",4000.0,12.0,  10),
                new Commodity("HP02", "06", "HP",3000.0,12.0,  8)
                    };
        String message = "成功创建了"+shop.length+"个商品";
        System.out.println(message);
        //构建商品索引
        SetQuery setQuery = new SetQuery();
        for(Commodity c : shop){
            setQuery.addCommodity(c);
            System.out.println("已添加: " + c.getName());
        }
        System.out.println("商品索引添加完毕");

        System.out.println("根据商品名称进行查询:");
        SearchInfo searchInfo = new SearchInfo();
        searchInfo.setName("HW01");//查询商品名称为“HW01”的商品信息
        List<Commodity> query = setQuery.search(searchInfo);
        System.out.println("-> 共找到"+query.size()+"件商品");
        for(Commodity c : query){
            System.out.println("------------------");
            System.out.println(c);
        }

        System.out.println("根据一个商品属性进行查询");
        SearchInfo searchInfo_1  = new SearchInfo();
        searchInfo_1.setScreenSize(14.0);
       List<Commodity> queryResult1 = setQuery.search(searchInfo_1);
       System.out.println("->  共找到"+queryResult1.size()+"件商品");
       for (Commodity c : queryResult1){
           System.out.println("-------------------");
           System.out.println(c);
       }

       System.out.println("根据多个商品属性进行查询");
       SearchInfo searchInfo_2  = new SearchInfo();
       searchInfo_2.setScreenSize(12.0);
       searchInfo_2.setPrice(4000.0);
       searchInfo_2.setBrand("MC");
       List<Commodity> queryResult2 = setQuery.search(searchInfo_2);
       System.out.println("->  共找到"+queryResult2.size()+"件商品");
       for (Commodity c : queryResult2){
           System.out.println("-------------------");
           System.out.println(c);
       }

       System.out.println("------String的举例说明部分-------");
       System.out.println("String与StringBuilder");
       System.out.println("1.使用String作为哈希表中的键：");
       String key_A = "abc";
       Map<String, Integer> testmap = new HashMap<>();
       testmap.put(key_A,1);
       System.out.println("key_A在哈希表中存储的值为"+testmap.get(key_A));
       String key_B = "abc";
       System.out.println("key_A:"+key_A);
       System.out.println("key_B:"+key_B);
       System.out.println("使用与key_A相同的key_B进行查找");
       if(testmap.containsKey(key_B)){
           System.out.println("key_B可以找到key_A的值:"+testmap.get(key_B));
       }
       else{System.out.println("哈希表中找不到这个值");}

       System.out.println("2.使用StringBuilder作为哈希表的键");
       StringBuilder key_A2 = new StringBuilder("abc");
       Map<StringBuilder, Integer> testmap2 = new HashMap<>();
       testmap2.put(key_A2,2);
       System.out.println("key_A2在哈希表中存储的值为："+testmap2.get(key_A2));
       StringBuilder key_B2 = new StringBuilder("abc");
       System.out.println("key_A2："+key_A2);
       System.out.println("key_B2："+key_B2);
       System.out.println("使用与key_A2相同的key_B2进行查找:");
       if(testmap2.containsKey(key_B2)){
           System.out.println(testmap2.get(key_B2));
       }
       else {
           System.out.println("哈希表中找不到这个键，无法获取值");
       }

       System.out.println("3.使用new String作为哈希表的键");
       String key_A3 = new String("abc");
       Map<String, Integer> testmap3 = new HashMap<>();
       testmap3.put(key_A3,3);
       System.out.println("key_A3在哈希表中存储的值为："+testmap3.get(key_A3));
       String key_B3 = new String("abc");
       System.out.println("key_A3："+key_A3);
       System.out.println("key_B3："+key_B3);
       System.out.println("使用与key_A3相同的key_B3进行查找:");
       if(testmap3.containsKey(key_B3)){
           System.out.println(testmap3.get(key_B3));
       }
       else {
           System.out.println("哈希表中找不到这个键，无法获取值");
       }

       System.out.println("---------比较String的new赋值与字面赋值的区别---------");
       String test1 = "abc";
       String test2 = "abc";
       String test3 = new String("abc");
       String test4 = new String("abc");
       System.out.println("test1=test2?\n"+ (test1==test2));
       System.out.println("test1=test3?\n"+ (test1==test3));
       System.out.println("test3=test4?\n"+ (test3==test4));
       System.out.println("\n--- 使用 System.identityHashCode() 查看对象ID ---");
       System.out.println("test1 的身份ID: " + System.identityHashCode(test1));
       System.out.println("test2 的身份ID: " + System.identityHashCode(test2));
       System.out.println("test3 的身份ID: " + System.identityHashCode(test3));
       System.out.println("test4 的身份ID: " + System.identityHashCode(test4));
   }
}