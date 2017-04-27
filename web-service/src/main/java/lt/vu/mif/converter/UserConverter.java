package lt.vu.mif.converter;

import lt.vu.mif.domain.User;
import lt.vu.mif.domain.UserResult;
import org.springframework.stereotype.Service;

/**
 * Created by s77323 on 4/26/2017.
 */
@Service
public class UserConverter {

    public UserResult convertFrom(final User user) {
        return new UserResult(
                user.getPersonalId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmailAddress());
    }
}
