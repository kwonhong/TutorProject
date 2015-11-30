package com.springapp.mvc.dao;


import com.springapp.mvc.event.Reservation;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReservationDao extends AbstractDao {

    public void createReservation(Reservation reservation) {
        persist(reservation);
    }

    public List<Reservation> findReservations(int userid) {
        Criteria criteria = getSession().createCriteria(Reservation.class);
        criteria.add(Restrictions.eq("userid", userid));
        List <Reservation> reservations = criteria.list();
        return reservations;
    }

    public Reservation findReservationWithEventAndUserId(int userId, int eventId) {
        Criteria criteria = getSession().createCriteria(Reservation.class);
        criteria.add(Restrictions.eq("userid", userId));
        criteria.add(Restrictions.eq("eventid", eventId));
        return (Reservation) criteria.list().get(0);
    }

    public void deleteReservation(Reservation reservation) {
        delete(reservation);
    }


}
