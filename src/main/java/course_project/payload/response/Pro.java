package course_project.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pro {
    int id;
    String name;
    double price;
    String imageUrl;
}
