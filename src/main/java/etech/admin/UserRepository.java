package etech.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etech.security.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String> {

    MyUser findMyUserByNameLike(String username);
}