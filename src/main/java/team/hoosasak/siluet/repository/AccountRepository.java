package team.hoosasak.siluet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import team.hoosasak.siluet.model.Account;

import java.util.Optional;

@Repository
@Service
public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByToken(String token);

}
