package pl.com.vigo.comprel.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputersDao extends JpaRepository<Computers, Integer> {
    List<Computers> findByComputersCat(ComputersCat computersCat);
}
