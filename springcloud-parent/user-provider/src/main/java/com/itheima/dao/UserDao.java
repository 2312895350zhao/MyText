package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.itheima.dao
 * Created on 2020/3/13.
 */
public interface UserDao extends JpaRepository<User,Integer> {

}
