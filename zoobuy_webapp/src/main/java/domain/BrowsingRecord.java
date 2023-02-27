package domain;

import java.util.Date;

public class BrowsingRecord {
    private Integer uid;
    private Integer gid;
    private Date btime;
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
    public Date getBtime() {
        return btime;
    }
    public void setBtime(Date btime) {
        this.btime = btime;
    }
}
