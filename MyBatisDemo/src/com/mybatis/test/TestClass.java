package com.mybatis.test;

import com.mybatis.dao.UserDAO;
import com.mybatis.model.User;

public class TestClass {

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        /*
         * System.out.println("--------------------findUsers----------------------"
         * );
         * 
         * List<User> userList = dao.findUsers(); for (Iterator<User> itr =
         * userList.iterator(); itr.hasNext();) { User temp = itr.next();
         * System.out.print("User ID: " + temp.getId());
         * System.out.print("  Username: " + temp.getUsername());
         * System.out.println("  Password: " + temp.getPassword()); }
         * 
         * System.out.println("---------------------addUser---------------------"
         * );
         * 
         * User newUser = new User(); newUser.setUsername("Lili");
         * newUser.setPassword("abc123_"); System.out.println("New user id is: "
         * + newUser.getId() + " before insert"); dao.addUser(newUser);
         * System.out.println("New user id is: " + newUser.getId() +
         * " after insert");
         * 
         * System.out.println(
         * "---------------------findUserByNameAndPassoword---------------------"
         * );
         * 
         * List<UserInfoDTO> userInfoList =
         * dao.findUserByNameAndPassoword("John", "111111"); for
         * (Iterator<UserInfoDTO> itr = userInfoList.iterator(); itr.hasNext();)
         * { UserInfoDTO userInfo = itr.next(); System.out.print("User ID: " +
         * userInfo.getId()); System.out.print("  Username: " +
         * userInfo.getUsername()); System.out.print("  Password: " +
         * userInfo.getPassword()); System.out.println("  Role: " +
         * userInfo.getRoleName()); }
         * 
         * System.out.println(
         * "-------------------findUsersOrderWithOption----------------------");
         * 
         * List<User> userListWithOrder =
         * dao.findUsersOrderWithOption("username"); for (Iterator<User> itr =
         * userListWithOrder.iterator(); itr.hasNext();) { User temp =
         * itr.next(); System.out.print("User ID: " + temp.getId());
         * System.out.print("  Username: " + temp.getUsername());
         * System.out.println("  Password: " + temp.getPassword()); }
         */

        System.out.println("-------------------findUserCount----------------------");

        System.out.println("The total user count is: " + dao.findUserCount());

        System.out.println("-------------------findUserById-----------------------");

        User user = dao.findUserById(1);
        System.out.println(user.getUsername() + "  " + user.getPassword());

        // Map map = dao.findUsersByIdWithMap(1);

        // dao.deleteUserById(1);

    }

}
