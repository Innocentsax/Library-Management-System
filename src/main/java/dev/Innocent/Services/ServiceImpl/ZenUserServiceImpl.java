package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.ZenUser;
import dev.Innocent.Repository.ZenUserRepository;
import dev.Innocent.Services.ZenUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZenUserServiceImpl implements ZenUserService {

    private ZenUserRepository userRepository;

    @Autowired
    public ZenUserServiceImpl(ZenUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<ZenUser> getAllZenUsers() {
        return userRepository.findAllByOrderByDisplayNameAsc();
    }

    @Override
    public List<ZenUser> getAllActiveZenUsers() {
        return userRepository.findAllByActiveOrderByDisplayNameAsc(1);
    }

    @Override
    public ZenUser getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public ZenUser getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ZenUser addNewZenUser(ZenUser zenUser) {
        zenUser.setPassword(zenUser.getPassword() );
        zenUser.setCreatedDate(new Date() );
        zenUser.setLastModifiedDate( zenUser.getCreatedDate() );
        zenUser.setActive(1);
        return userRepository.save(zenUser);
    }

    @Override
    public ZenUser updateZenUser(ZenUser zenUser) {
        zenUser.setLastModifiedDate( new Date() );
        return userRepository.save( zenUser );
    }

    @Override
    public void deleteZenUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> deleteZenUser(ZenUser zenUser) {
        userRepository.delete(zenUser);
        return ResponseEntity.ok().build();
    }
}
