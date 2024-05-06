package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {


    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
//
//
//        Car car1 = new Car("bmw", 7);
//        userService.addu(car1);
//////
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//        userService.add(user1);

//        new Car("mb", 500);
//        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//        user2.setCar(car1);
//        userService.add(user2);

//
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car1));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 650)));
//
//
        userService.addCar(new Car("sgt", 5));
        userService.addCar(new Car("sgt", 5, user1));

        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 650)));
        userService.addCar(new Car("sgt", 5, user1));

//
//,new Car("sgt", 5)


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar());
//         System.out.println();
//      }
//
//      System.out.println(userService.getUserByCarModelAndSeries("dsg",7));
//      System.out.println(userService.getUserByCarModelAndSeries("BMW",650));
//      System.out.println(userService.getUserByCarModelAndSeries("BMW",600));
        context.close();


    }

}
