package bikes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BikesController {
    private BikesService bikesService;

    public BikesController(BikesService bikesService) {
        this.bikesService = bikesService;
    }

    @GetMapping("/history")
    public List<BikesDto> listBikes() {
        return bikesService.listBikes();
    }

    @GetMapping("/users")
    public List<String> listUsers() {
        return bikesService.listUsers();
    }
}
