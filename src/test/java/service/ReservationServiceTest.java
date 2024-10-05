package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onlineLessonReservationSystem.model.Reservation;
import org.onlineLessonReservationSystem.repository.ReservationRepository;
import org.onlineLessonReservationSystem.service.ReservationService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllReservations() {
        // Mock response
        when(reservationRepository.findAll()).thenReturn(Collections.emptyList());

        // Service metodunu çağırıyoruz
        List<Reservation> reservations = reservationService.findAll();

        // Assert ve doğrulamalar
        assertEquals(0, reservations.size());
        verify(reservationRepository, times(1)).findAll();
    }
}
