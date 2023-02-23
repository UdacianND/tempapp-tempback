package course_project.controller;

import course_project.payload.request.OrderDto;
import course_project.payload.response.OrderHistoryDto;
import course_project.payload.response.OrderedProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
    @PostMapping("order")
    public HttpEntity<?> postOrder(
            @RequestBody OrderDto orderDto
            ){
        int a = 1;
        return ResponseEntity.ok("yetkazildi");
    }

    @GetMapping("order/history")
    public HttpEntity<?> getOrderHistory(
            @RequestParam String lang
    ){
        List<OrderHistoryDto> data = List.of(
                new OrderHistoryDto(1, new Date(), List.of(
                        new OrderedProductDto(1, "Cola", 2, 9000, "Evos")
                ))
        );
        List<OrderHistoryDto> dataRu = List.of(
                new OrderHistoryDto(1, new Date(), List.of(
                        new OrderedProductDto(1, "ColaRu", 2, 9000, "EvosRU")
                ))
        );
        return ResponseEntity.ok(lang.equals("uz")? data : dataRu);
    }

    @DeleteMapping("order/history")
    public  HttpEntity<?> delete(){
        return ResponseEntity.ok(null);
    }
}
