/** SearchInfo类用于获取用户的检索需求，可以使用户灵活选取检索商品时所依据的属性数量*/
public class SearchInfo {
    private String cid;
    private String name;
    private Double price;
    private Double screenSize;
    private String brand;
    public  String getCid() {
        return cid;
    }
    public void setCid(String cid) {this.cid = cid;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public Double getScreenSize() {return screenSize;}
    public void setScreenSize(Double screenSize) {this.screenSize = screenSize;}
    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

}
