package team.hoosasak.siluet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.hoosasak.siluet.model.Account;
import team.hoosasak.siluet.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account add(Account account) {
        return repository.save(account);
    }

    public Optional<Account> get(String token) {
        return repository.findByToken(token);
    }

}
