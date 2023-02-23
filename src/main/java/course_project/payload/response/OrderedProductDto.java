package course_project.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProductDto {
    int id;
    String name;
    int count;
    double price;
    String institution;
}
