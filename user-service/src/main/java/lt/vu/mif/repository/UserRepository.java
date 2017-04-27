package lt.vu.mif.repository;

import lt.vu.mif.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by s77323 on 3/2/2017.
 */

public interface UserRepository extends Repository<User, Long> {

    public List<User> findAll();

    public User findById(Long id);

    public User findByPersonalId(Long personalId);

    public List<User> findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);

    public User findByEmailAddress(String emailAddress);

    public User findByPhoneNumber(String phone);

    @Query("SELECT count(*) from User")
    public int countUsers();

    @Transactional
    public User save(User user);

    @Transactional
    @Modifying
    public void deleteUserById(Long id);

    @Transactional
    @Modifying
    public void deleteUserByPersonalId(Long personalId);

    @Transactional
    @Modifying
    @Query("DELETE from User")
    public void deleteUsers();
}
