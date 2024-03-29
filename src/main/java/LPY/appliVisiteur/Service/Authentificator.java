package LPY.appliVisiteur.Service;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UsersRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class Authentificator {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UsersRepository usersRepository;

    public User getUser() throws UserNotFoundException {
        String token = request.getHeader("authorization");
        if (token == null)
        {
            throw  new UserNotFoundException("invalid token");
        }
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        Optional<User> user = usersRepository.findById(jwt.getClaim("id").asLong());
        if (user.isPresent()) {
            return user.get();
        }
        else
        {
            throw new UserNotFoundException("invalid token");
        }
    }
}
