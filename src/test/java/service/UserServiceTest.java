package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onlineLessonReservationSystem.model.User;
import org.onlineLessonReservationSystem.repository.UserRepository;
import org.onlineLessonReservationSystem.service.UserService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllUsers() {
        // Mock response
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        // Service metodunu çağırıyoruz
        List<User> users = userService.findAll();

        // Assert ve doğrulamalar
        assertEquals(0, users.size());
        verify(userRepository, times(1)).findAll();
    }
}
