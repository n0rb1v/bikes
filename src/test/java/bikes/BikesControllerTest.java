package bikes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BikesControllerTest {

    @Mock
    BikesService service;
    @InjectMocks
    BikesController controller;

    @Test
    void listBikes() {
        when(service.listBikes()).thenReturn(List.of(
                new BikesDto("a","1", LocalDateTime.of(2021,6,26,15,22,11),1.7),
                new BikesDto("b","2", LocalDateTime.of(2021,6,26,11,22,11),3.7)
        ));
        assertThat(controller.listBikes())
                .hasSize(2)
                .extracting(BikesDto::getId)
                .containsExactly("a","b");
    }

    @Test
    void listUsers() {
        when(service.listUsers()).thenReturn(List.of(
                "1","2"
        ));
        assertThat(controller.listUsers())
                .hasSize(2)
                .containsExactly("1","2");
    }
}