package bikes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BikesControllerIT {

    @Autowired
    BikesController controller;

    @Test
    void listBikes() {
        List<BikesDto> result = controller.listBikes();
        assertThat(result)
                .hasSize(5)
                .extracting(BikesDto::getId)
                .contains("FH675","FH676","FH636","FH631");
    }

    @Test
    void listUsers() {
        List<String> result = controller.listUsers();
        assertThat(result)
                .hasSize(5)
                .contains("US3434","US3a34","US3334","US336","US346");
    }
}