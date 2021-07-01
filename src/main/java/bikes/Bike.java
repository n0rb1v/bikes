package bikes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
    private String id;
    private String user;
    private LocalDateTime rentTime;
    private double length;
}
