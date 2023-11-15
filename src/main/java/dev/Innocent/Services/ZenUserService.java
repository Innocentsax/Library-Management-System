package dev.Innocent.Services;

import dev.Innocent.Model.ZenUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZenUserService {

    List<ZenUser> getAllZenUsers();

    List<ZenUser> getAllActiveZenUsers();

    ZenUser getById(Long id);

    ZenUser getByUsername(String username);

    ZenUser addNewZenUser(ZenUser zenUser);

    ZenUser updateZenUser(ZenUser zenUser);

    void deleteZenUser(Long id);

    ResponseEntity<?> deleteZenUser(ZenUser zenUser);
}
