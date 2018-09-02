package pl.com.vigo.comprel.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputersCatDao extends JpaRepository<ComputersCat, Integer> {
}
