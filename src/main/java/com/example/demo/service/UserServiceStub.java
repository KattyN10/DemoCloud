package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class UserServiceStub {
    private static Map<Integer, User> userMap = new HashMap<>();
    private List<User> list = new ArrayList<User>();

    private static int index = 3;
    static {
        User user1 = new User(1, "Khoa");
        User user2 = new User(2,"Phúc");
        User user3 = new User(3,"Hoàng");
        userMap.put(1,user1);
        userMap.put(2,user2);
        userMap.put(3,user3);
    }
    public static List<User> getAllUser(){
        return new ArrayList<>(userMap.values());
    }

    public static User findById(int userid){
        return userMap.get(userid);
    }

    public static User addUser(User user)
    {
        index += 1;
        user.setId(index);
        userMap.put(index,user);
        return user;
    }
    public static User saveUpdate(int userid, User user) {
        user.setId(userid);
        userMap.put(userid,user);
        return user;
    }
    public static User deleteUser(int userid) {
        return userMap.remove(userid);
    }
    public User updateUser(User user){
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (user.getId())) {
                id = user.getId();
                idx = i;
                break;
            }
        }
        User user1 = new User();
        user1.setId(id);
        user1.setName(user.getName());
        list.set(idx, user);
        return user1;
    }
}
