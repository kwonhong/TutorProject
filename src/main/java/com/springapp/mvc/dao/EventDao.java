package com.springapp.mvc.dao;

import com.springapp.mvc.event.Event;
import com.springapp.mvc.event.Reservation;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.*;


@Component
@Transactional
public class EventDao extends AbstractDao {

    public List<Event> findAllEvents(int userid, ArrayList<Integer> filter) {
        Criteria criteria = getSession().createCriteria(Event.class);
        for (int a : filter){
            criteria.add(Restrictions.ne("id", a));
        }
        List <Event> eventList = criteria.list();
        return eventList;
    }

    public Event findEventById(int eventID) {
        Criteria criteria = getSession().createCriteria(Event.class);
        criteria.add(Restrictions.eq("id", eventID));
        return (Event) criteria.uniqueResult();
    }

    public void insertEvent(Event event) {
        persist(event);
    }

    public void updateEvent(Event event) {
        getSession().update(event);
    }

    public void deleteEvent(Event event) {
        getSession().delete(event);
    }

    public void deleteEventById(int eventID) {
        Query query = getSession().createSQLQuery("delete from event where id = :id");
        query.setInteger("id", eventID);
        query.executeUpdate();

    }
}
