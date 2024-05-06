package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void addCar(Car car);
    List<User> listUsers();
    User getUserByCarModelAndSeries(String carModel, int carSeries);
}
