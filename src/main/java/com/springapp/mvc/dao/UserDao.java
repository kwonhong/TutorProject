package com.springapp.mvc.dao;

import com.springapp.mvc.UserData;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao extends AbstractDao {

    public List<UserData> findAllLoginData() {
        Criteria criteria = getSession().createCriteria(UserData.class);
        List<UserData> userData = criteria.list();
        return userData;
    }

}
