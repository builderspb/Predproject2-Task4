package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCarModelAndSeries(String carModel, int carSeries) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series");

        query.setParameter("model", carModel);
        query.setParameter("series", carSeries);
        return (User) query.getSingleResult();
    }
}
