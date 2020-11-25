package fr.umontpellier.fds.m2.springboottp.repositories;

import fr.umontpellier.fds.m2.springboottp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}