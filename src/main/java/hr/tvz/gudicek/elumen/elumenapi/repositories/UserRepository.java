package hr.tvz.gudicek.elumen.elumenapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.gudicek.elumen.elumenapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Long countByFacebookId(String facebookId);

	public User findByFacebookId(String facebookId);

}