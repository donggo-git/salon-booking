package dongcom.repository;

import dongcom.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface UserRepository extends JpaRepository<User, Long> {

}
