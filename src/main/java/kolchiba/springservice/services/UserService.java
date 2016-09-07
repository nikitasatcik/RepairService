package kolchiba.springservice.services;

import kolchiba.springservice.domain.User;

public interface UserService  {
    Iterable<User> findAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    User deleteUserById(Integer id, User user);


}
