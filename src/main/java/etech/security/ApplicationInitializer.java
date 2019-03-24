package etech.security;

import java.util.Date;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import etech.admin.UserRepository;

@Component	
public class ApplicationInitializer implements CommandLineRunner {
	
	Log logger = LogFactory.getLog(ApplicationInitializer.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()){

            MyUser user = new MyUser("admin", "123", AuthorityUtils.NO_AUTHORITIES);
            user.setCreated(new Date());
            user.setEmail("admin@etech-systems.com");
            user.setName("Mohammad");

            userRepository.save(user);
            
            logger.info("NO USERS AVAILABLE / DEFAULT USER CREATED : ( " + user.getUsername() + " : " + user.getPassword() + " )");
        }
    }
}
