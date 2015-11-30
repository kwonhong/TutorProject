package com.springapp.mvc.dao;

import com.springapp.mvc.event.Event;
import com.springapp.mvc.event.Reservation;
import com.springapp.mvc.function.FindDistance;
import com.springapp.mvc.user.UserData;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.*;


@Component
@Transactional
public class EventDao extends AbstractDao {

    @Autowired
    private UserDao userDao;

    public List<Event> findAllEvents(){
        return getSession().createCriteria(Event.class).list();
    }

    public List<Event> findAllEventsNotReserved(ArrayList<Integer> filter) {
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

    public void occupyEvent(int eventid){
        Event event = findEventById(eventid);
        int current = event.getNumParticipants();
        event.setNumParticipants(current+1);
    }

    public List<Event> searchNearbyEvents(int userid, ArrayList<Integer> filter)
    {
        FindDistance findDistance = new FindDistance();
        UserData user = userDao.findUserById(userid);
        double userlat = user.getGeolat();
        double userlon = user.getGeolon();
        List <Event> allEvents = findAllEventsNotReserved(filter);
        ArrayList <Event> nearBy = new ArrayList <Event>();
        for (Event event : allEvents){
            double eventlat = event.getGeolat();
            double eventlon = event.getGeolon();
            double distance = findDistance.haversine(userlat,userlon,eventlat,eventlon);
            System.out.println(distance);
            if (distance < 30.0) nearBy.add(event);
        }
        return nearBy;
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

    public List<Event> searchEventByQuery(ArrayList<Integer> filter, String searchInput) {
        Criteria criteria = getSession().createCriteria(Event.class);
        for (int a : filter){
            criteria.add(Restrictions.ne("id", a));
        }

        List <Event> eventList = criteria.list();

        String sqlQuery = "SELECT * from event where name LIKE \'%" + searchInput + "%\' OR " +
                "description LIKE '%\" + searchInput + \"%'";
        List<Event> eventList2 =  getSession().createSQLQuery(sqlQuery).addEntity(Event.class).list();

        eventList.retainAll(eventList2);
        return eventList;
    }
}
