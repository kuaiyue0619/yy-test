package my.ky.test.dal.mongo;

import my.ky.test.dal.model.User;
//import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <ul>
 * <li>描述类的作用</li>
 * <li>User:ky Date:2018/1/24 Time:15:29</li>
 * </ul>
 */
public interface UserRepository /*extends MongoRepository<User, Long>*/ {

    User findByName(String username);
}
