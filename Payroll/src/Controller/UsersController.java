/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.UsersDaoImpl;
import Model.Users;

/**
 *
 * @author Samir
 */
public class UsersController {
    Users users = new Users();
    UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public int isValidUser(){
        return usersDaoImpl.isValidUser(users.getUsername(),users.getPassword()
                ,users.getType());
    }

    public int changepass(String newpass) {
        return usersDaoImpl.changepass(users.getUsername(),users.getPassword(),newpass);
    }

    public String getuser() {
        return usersDaoImpl.giveuser(users.getUsername());
    }
    
}
