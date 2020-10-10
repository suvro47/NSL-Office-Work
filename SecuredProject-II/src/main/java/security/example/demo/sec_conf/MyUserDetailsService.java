package security.example.demo.sec_conf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import security.example.demo.AppUser;
import security.example.demo.AppUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AppUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> OpUser = repo.findByUsername(username);
		System.out.println(OpUser);
		if( ! OpUser.isPresent() ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		}
		AppUser user = OpUser.get(); 
		return new MyUserDetails(user);
	}

}


