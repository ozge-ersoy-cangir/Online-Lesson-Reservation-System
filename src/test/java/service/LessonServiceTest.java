package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onlineLessonReservationSystem.model.Lesson;
import org.onlineLessonReservationSystem.repository.LessonRepository;
import org.onlineLessonReservationSystem.service.LessonService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LessonServiceTest {

    @Mock
    private LessonRepository lessonRepository;

    @InjectMocks
    private LessonService lessonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllLessons() {
        // Mock response
        when(lessonRepository.findAll()).thenReturn(Collections.emptyList());

        // Service metodunu çağırıyoruz
        List<Lesson> lessons = lessonService.findAll();

        // Assert ve doğrulamalar
        assertEquals(0, lessons.size());
        verify(lessonRepository, times(1)).findAll();
    }
}
