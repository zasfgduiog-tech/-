import java.util.Objects;

public class Commodity {
    //定义商品的各个属性
    private String name;//商品名称
    private Double price;//商品价格
    private Double screenSize;//商品屏幕大小
    private String cid;//商品ID，唯一标识符
    private int count;//商品剩余数量
    private String brand;//商品品牌
    public Commodity(String name, String cid,String brand,Double price, Double screenSize, int count) {
        this.name = name;
        this.price = price;
        this.screenSize = screenSize;
        this.cid = cid;
        this.count = count;
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}
    @Override
    public String toString() {
        return "商品名\t"+name+"\n"+"商品ID\t"+cid+"\n"+"商品品牌\t"+brand+"\n"+"商品价格\t"+price+"\n"+"商品屏幕大小\t"+screenSize+"寸"+"\n"+"商品剩余数量\t"+count;
}
    // 重写 equals与hashcode方法，使哈希表在判断时可以根据商品ID判断是否为同一商品，从而避免检索出多余项（不过在本次实验中似乎没用）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Objects.equals(cid, commodity.cid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid);
    }
}