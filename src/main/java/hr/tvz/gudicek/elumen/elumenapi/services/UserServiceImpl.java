package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.gudicek.elumen.elumenapi.entities.User;
import hr.tvz.gudicek.elumen.elumenapi.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveOrUpdate(User entity) {
		userRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}

	@Override
	public User get(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User facebookUserLogin(User user) {
		if (userRepository.countByFacebookId(user.getFacebookId()) == 0) {
			userRepository.save(user);
		}
		return userRepository.findByFacebookId(user.getFacebookId());
	}

	@Override
	public Long countByFacebookId(String facebookId) {
		return userRepository.countByFacebookId(facebookId);
	}

	@Override
	public User findByFacebookId(String facebookId) {
		return userRepository.findByFacebookId(facebookId);
	}

}
