package com.springapp.mvc.dao;


import com.springapp.mvc.event.Reservation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReservationDao extends AbstractDao {

    public List<Reservation> findAllReservations() {
        return getSession().createCriteria(Reservation.class).list();
    }

    public void createReservation(Reservation reservation) {
        persist(reservation);
    }

    public List<Reservation> findReservation(int userid) {
        Criteria criteria = getSession().createCriteria(Reservation.class);
        criteria.add(Restrictions.eq("userid", userid));
        List <Reservation> reservations = criteria.list();
        return reservations;
    }


}
