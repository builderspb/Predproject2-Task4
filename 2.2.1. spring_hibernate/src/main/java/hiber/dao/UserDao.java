package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);

   void addCar(Car car);

   List<User> listUsers();

   public User getUserByCarModelAndSeries(String carModel, int carSeries);


}
