/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Samir
 */
public interface UsersDao {
    public int isValidUser(String username, String password, String type);
    public int changepass(String username, String password, String newpass);
    public String giveuser(String username);
}
