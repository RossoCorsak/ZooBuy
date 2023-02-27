package domain;

public class Cart {
    private Integer uid;
    private Integer gid;

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Cart [uid=" + uid + ", gid=" + gid + "]";
    }
}
