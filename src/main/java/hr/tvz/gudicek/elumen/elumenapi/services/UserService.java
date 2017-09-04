package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import hr.tvz.gudicek.elumen.elumenapi.entities.User;

public interface UserService {

	public void saveOrUpdate(User entity);

	public void delete(int id);

	public User get(int id);

	public List<User> findAll();

	public Long countByFacebookId(String facebookId);

	public User facebookUserLogin(User user);

	public User findByFacebookId(String facebookId);
}
