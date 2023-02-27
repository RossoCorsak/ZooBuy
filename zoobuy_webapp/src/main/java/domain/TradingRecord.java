package domain;

public class TradingRecord {
    private Integer tid;
    private Integer uid;
    private Integer gid;
    private Double price;
    private String gname;
    private String image;
    private String realname;
    private String phone;
    private String address;
    private Double pay;

    public Integer getTid() {
        return tid;
    }
    public void setTid(Integer id) {
        this.tid = id;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer id) {
        this.uid = id;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer id) {
        this.gid = id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getGname() {
        return gname;
    }
    public void setGname(String name) {
        this.gname = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getRealname() {
        return realname;
    }
    public void setRealname(String name) {
        this.realname = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Double getPay() {
        return pay;
    }
    public void setPay(Double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "TradingRecord [tid=" + tid + ", uid=" + uid + ", gid=" + gid + ", price=" + price + ", gname=" + gname + ", image=" + image + ", realname=" + realname + ", phone=" + phone + ", address=" + address + ", pay=" + pay + "]";
    }
}
