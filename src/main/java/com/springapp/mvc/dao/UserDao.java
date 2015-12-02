package com.springapp.mvc.dao;

import com.springapp.mvc.model.UserData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    public UserData findUserById(int userID) {
        Criteria criteria = getSession().createCriteria(UserData.class);
        criteria.add(Restrictions.eq("id", userID));
        return (UserData) criteria.uniqueResult();
    }

    public UserData findUserByUserName(String username){
        Criteria criteria = getSession().createCriteria(UserData.class);
        criteria.add(Restrictions.eq("username", username));
        return (UserData) criteria.uniqueResult();
    }

}
