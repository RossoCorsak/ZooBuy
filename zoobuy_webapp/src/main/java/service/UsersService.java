package service;

import dao.UsersDao;
import domain.*;

public class UsersService {
    private UsersDao ud = new UsersDao();

    public int register(Users user){
        return ud.addNewUsers(user);
    }

    public Users login(Users user){
        return ud.findUsersByUidAndPassword(user);
    }
}
