package bikes;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikesService {
    private ModelMapper modelMapper;

    private List<Bike> bikes = new ArrayList<>();

    public BikesService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void loadFile() { // Path.of("src/main/resources/);
        try (BufferedReader bf = Files.newBufferedReader(Path.of("src/main/resources/bikes.csv"))) {
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while ((line = bf.readLine()) != null) {
                String[] result = line.split(";");
                bikes.add(new Bike(result[0],result[1], LocalDateTime.parse(result[2],formatter),Double.parseDouble(result[3])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("file error");
        }
    }
    public List<BikesDto> listBikes() {
        if (bikes.size() == 0) {
            loadFile();
        }
        Type targetListType = new TypeToken<List<BikesDto>>() {}.getType();
        return modelMapper.map(bikes,targetListType);
    }

    public List<String> listUsers() {
        return bikes.stream()
                .map(Bike::getUser)
                .collect(Collectors.toList());
    }
}
