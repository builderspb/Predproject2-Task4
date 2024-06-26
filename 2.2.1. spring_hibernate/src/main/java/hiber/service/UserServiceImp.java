package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        userDao.addCar(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUserByCarModelAndSeries(String carModel, int carSeries) {
        return userDao.getUserByCarModelAndSeries(carModel,carSeries);
    }


//   SELECT User FROM User JOIN User.car WHERE User.car.model = :model AND User.car.series = :series

}
