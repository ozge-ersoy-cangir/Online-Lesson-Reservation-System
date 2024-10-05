package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.onlineLessonReservationSystem.controller.LessonController;
import org.onlineLessonReservationSystem.service.LessonService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class LessonControllerTest {

    @Mock
    private LessonService lessonService;

    @InjectMocks
    private LessonController lessonController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // MockMvc nesnesini ayarlıyoruz
        mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
    }

    @Test
    void testGetAllLessons() throws Exception {
        // Mock response
        when(lessonService.findAll()).thenReturn(Collections.emptyList());

        // MockMvc üzerinden get isteği yapıyoruz
        mockMvc.perform(get("/lessons"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(lessonService, times(1)).findAll();
    }
}