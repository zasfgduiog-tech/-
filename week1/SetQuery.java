import java.util.*;

public class SetQuery {
    HashMap<String, List<Commodity>> nameIndex = new HashMap<>();
    HashMap<Double, List<Commodity>> priceIndex = new HashMap<>();
    HashMap<Double, List<Commodity>> screenIndex = new HashMap<>();
    HashMap<String, List<Commodity>> idIndex = new HashMap<>();
    HashMap<String, List<Commodity>> brandIndex = new HashMap<>();

    /**
     * addCommodity 通过构建多个商品属性的哈希表来构建商品属性索引，类似于倒排文档
     * @param c 为传入的商品实例
     */
    public void addCommodity(Commodity c) {
        List<Commodity> nameList = nameIndex.getOrDefault(c.getName(), new ArrayList<>());
        nameList.add(c);
        nameIndex.put(c.getName(), nameList);

        List<Commodity> priceList = priceIndex.getOrDefault(c.getPrice(), new ArrayList<>());
        priceList.add(c);
        priceIndex.put(c.getPrice(), priceList);

        List<Commodity> screenList = screenIndex.getOrDefault(c.getScreenSize(), new ArrayList<>());
        screenList.add(c);
        screenIndex.put(c.getScreenSize(), screenList);

        List<Commodity> idList = idIndex.getOrDefault(c.getCid(), new ArrayList<>());
        idList.add(c);
        idIndex.put(c.getCid(), idList);

        List<Commodity> brandList = brandIndex.getOrDefault(c.getBrand(), new ArrayList<>());
        brandList.add(c);
        brandIndex.put(c.getBrand(), brandList);
    }
    /** intersection方法是自定义的求两个商品列表交集的方法。
     * 通过将一个列表用哈希集合存储，遍历另一个列表来求交集，
     * 主要用于执行多个商品属性检索时的高效率求并集，效率稳定在O(M+N)
     * @param lc1 是通过检索商品的某一个属性得到的商品列表
     * @param lc2 是不同于lc1的一个商品属性的商品列表
     * @return 同时满足这两个检索条件的商品列表
     * */
    public List<Commodity> intersection(List<Commodity> lc1, List<Commodity> lc2) {
        Set<Commodity> set = new HashSet<>(lc1);
        List<Commodity> result = new ArrayList<>();
        for (Commodity c : lc2) {
            if (set.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }
    /** getAllCommodities方法是返回所有商品的方法，用于用户给出的检索条件为空时的情况*/
    private List<Commodity> getAllCommodities() {
        Set<Commodity> allCommoditiesSet = new HashSet<>();
        // 遍历任何一个索引的所有值即可
        for (List<Commodity> list : nameIndex.values()) {
            allCommoditiesSet.addAll(list);
        }
        return new ArrayList<>(allCommoditiesSet);
    }

    /** search函数是进行商品多属性检索的核心逻辑
     * @param s 为传入的用户的检索条件
     * @return 满足用户检索条件的商品列表
     * */
    public List<Commodity> search(SearchInfo s) {
        // 1. 从一个包含所有商品的列表开始作为我们的初始候选集
        List<Commodity> candidates = getAllCommodities();

        // 2. 如果提供了名称，就用名称的查询结果来筛选（求交集）
        if (s.getName() != null) {
            // 使用 getOrDefault 并提供一个空列表作为默认值，彻底避免 null
            List<Commodity> nameResults = nameIndex.getOrDefault(s.getName(), new ArrayList<>());
            candidates = intersection(candidates,nameResults);
        }

        // 3. 如果提供了价格，继续在上面的结果上筛选
        if (s.getPrice() != null) {
            List<Commodity> priceResults = priceIndex.getOrDefault(s.getPrice(), new ArrayList<>());
            candidates = intersection(candidates,priceResults);
        }

        // 4. 如果提供了CID，继续筛选
        if (s.getCid() != null) {
            List<Commodity> cidResults = idIndex.getOrDefault(s.getCid(), new ArrayList<>());
            candidates = intersection(candidates,cidResults);
        }

        // 5. 如果提供了屏幕尺寸，继续筛选
        if (s.getScreenSize() != null) {
            List<Commodity> screenResults = screenIndex.getOrDefault(s.getScreenSize(), new ArrayList<>());
            candidates = intersection(candidates,screenResults);
        }
        if (s.getBrand() != null) {
            List<Commodity> brandResults = brandIndex.getOrDefault(s.getBrand(), new ArrayList<>());
            candidates = intersection(candidates,brandResults);
        }

        // 6. 返回经过所有有效条件筛选后的最终结果
        return candidates;
    }
}
