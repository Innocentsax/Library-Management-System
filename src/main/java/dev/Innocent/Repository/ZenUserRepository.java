package dev.Innocent.Repository;

import dev.Innocent.Model.ZenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZenUserRepository extends JpaRepository<ZenUser, Long> {
    public List<ZenUser> findAllByOrderByDisplayNameAsc();
    public List<ZenUser> findAllByActiveOrderByDisplayNameAsc(Integer active);
    public ZenUser findByUsername(String username);
}
