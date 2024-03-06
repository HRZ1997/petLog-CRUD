package com.example.petlog.sevice;

import com.example.petlog.entity.Role;
import com.example.petlog.entity.User;
import com.example.petlog.entity.UserInfo;
import com.example.petlog.repository.RoleRepository;
import com.example.petlog.repository.UserRepository;
import com.example.petlog.sevice.intefaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Transactional
    public User createUser(User user, UserInfo userInfo) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(1).get());

        // Set roles to the user
        user.setRoles(roles);

        // Set user to userInfo and vice versa
        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        //encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user along with userInfo and roles due to cascading
        return userRepository.save(user);

    }

}
