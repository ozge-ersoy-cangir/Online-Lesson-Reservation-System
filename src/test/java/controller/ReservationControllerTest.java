package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.onlineLessonReservationSystem.controller.ReservationController;
import org.onlineLessonReservationSystem.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ReservationControllerTest {

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // MockMvc nesnesini ayarlıyoruz
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    void testGetAllReservations() throws Exception {
        // Mock response
        when(reservationService.findAll()).thenReturn(Collections.emptyList());

        // MockMvc üzerinden get isteği yapıyoruz
        mockMvc.perform(get("/reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(reservationService, times(1)).findAll();
    }
}