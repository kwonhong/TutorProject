package com.springapp.mvc.dao;

import com.springapp.mvc.UserData;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserDao extends AbstractDao {

    public List<UserData> findAllLoginData() {
        Criteria criteria = getSession().createCriteria(UserData.class);
        List<UserData> userData = criteria.list();
        return userData;
    }

    public void createUser(UserData userData) {
        persist(userData);
    }

}
