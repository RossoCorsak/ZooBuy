package domain;

public class Goods {
    private Integer gid;
    private String gname;
    private Double price;
    private Integer stocks;
    private String image;
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer id) {
        this.gid = id;
    }
    public String getGname() {
        return gname;
    }
    public void setGname(String name) {
        this.gname = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStocks() {
        return stocks;
    }
    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Goods [id=" + gid + ", name=" + gname + ", price=" + price + ", stocks=" + stocks + ", image=" + image + "]";
    }
}

