package course_project.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ins {
    int id;
    String name;
    String imageUrl;
}
