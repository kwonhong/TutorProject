package com.springapp.mvc.dao;

import com.springapp.mvc.event.Event;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EventDao extends AbstractDao {

    public List<Event> findAllEvents() {
//        getSession().createCriteria(Event.class).list();
        String sqlQuery = "SELECT * from event";
        return getSession().createSQLQuery(sqlQuery).list();
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
