package com.eci.taskplanner.components.repository;

import com.eci.taskplanner.components.exceptions.UserException;
import com.eci.taskplanner.components.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> bdUser = new ArrayList();

    public List<User> findAll(){
        return bdUser;
    }

    public User findByName(String name){
        for (int i = 0; i < bdUser.size() ; i++ ){
            if (bdUser.get(i).getUsername().equals(name)){
                return bdUser.get(i);
            }
        }
        throw new UserException("El usuario " + name +" no existe");
    }


    public User save(User user){
        for (int i = 0; i < bdUser.size() ; i++ ){
            if (bdUser.get(i).getUsername().equals(user.getUsername())){
                throw new UserException("El usuario " + user.getUsername() + " ya existe");
            }
        }
        bdUser.add(user);
        return user;
    }

    public User update(User user){
        for (int i = 0; i < bdUser.size() ; i++ ){
            if (bdUser.get(i).getUsername().equals(user.getUsername())){
                bdUser.remove(i);
                bdUser.add(user);
            }
        }

        return user;
    }

    public void delete(String name){
        for (int i = 0; i < bdUser.size() ; i++ ){
            if (bdUser.get(i).getUsername().equals(name)){
                bdUser.remove(i);
            }
        }
        throw new UserException("El usuario " + name + " ya no existe");
    }
}
