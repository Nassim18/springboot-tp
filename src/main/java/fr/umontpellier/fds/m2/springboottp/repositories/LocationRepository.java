package fr.umontpellier.fds.m2.springboottp.repositories;

import fr.umontpellier.fds.m2.springboottp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

        }