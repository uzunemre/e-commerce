package com.emreuzun.unit.user;

import com.emreuzun.model.user.User;
import com.emreuzun.repository.user.UserRepository;
import com.emreuzun.service.user.UserService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserService();

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldInitializeWithOneDemoUsers() {
        userService.initialize();
        verify(userRepositoryMock, times(1)).save(any(User.class));
    }

    @Test
    public void shouldThrowExceptionWhenUserNotFound() {
        thrown.expect(UsernameNotFoundException.class);
        thrown.expectMessage("user not found");
        when(userRepositoryMock.findOneByUsername("user")).thenReturn(null);
        userService.loadUserByUsername("user");
    }

    @Test
    public void shouldReturnUserDetails() {
        User demoUser = new User("user", "demo");
        when(userRepositoryMock.findOneByUsername("user")).thenReturn(demoUser);

        UserDetails userDetails = userService.loadUserByUsername("user");

        assertThat(demoUser.getUsername()).isEqualTo(userDetails.getUsername());
        assertThat(demoUser.getPassword()).isEqualTo(userDetails.getPassword());
    }


}
