package course_project.controller;

import course_project.payload.response.Cat;
import course_project.payload.response.Ins;
import course_project.payload.response.InsType;
import course_project.payload.response.Pro;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BookController {

    @GetMapping("institutionTypes")
    public HttpEntity<?> getInsType(
        @RequestParam String lang
    ){
        List<InsType> data = List.of(
                new InsType(1, "Cafe")
        );
        List<InsType> dataRu = List.of(
                new InsType(1, "CafeRu")
        );
        return ResponseEntity.ok(lang.equals("uz")? data : dataRu);
    }

    @GetMapping("institutions/type/{id}")
    public HttpEntity<?> getIns(
            @PathVariable Long id,
            @RequestParam String lang
    ){
        List<Ins> data = List.of(
                new Ins(1, "Evos", "https://th.bing.com/th/id/OIP.com4sMfga2gwMCziijiREAHaHa?w=178&h=180&c=7&r=0&o=5&pid=1.7")
        );
        List<Ins> evosRu = List.of(
                new Ins(1, "EvosRu", "https://th.bing.com/th/id/OIP.com4sMfga2gwMCziijiREAHaHa?w=178&h=180&c=7&r=0&o=5&pid=1.7")
        );
        return ResponseEntity.ok(lang.equals("uz")? data : evosRu);
    }

    @GetMapping("categories/institution/{id}")
    public HttpEntity<?> getCat(
            @PathVariable Long id,
            @RequestParam String lang
    ){
        List<Cat> data = List.of(
                new Cat(1, "Ichimlik")
        );
        List<Cat> dataRu = List.of(
                new Cat(1, "IchimlikRu")
        );
        return ResponseEntity.ok(lang.equals("uz")? data : dataRu);
    }

    @GetMapping("products/category/{id}")
    public HttpEntity<?> getPro(
            @PathVariable Long id,
            @RequestParam String lang
    ){
        List<Pro> data = List.of(
                new Pro(1, "Cola", 9000, "https://th.bing.com/th/id/OIP.dNCYKENMQT0e6qVY3uzTzQHaE7?pid=ImgDet&rs=1")
        );
        List<Pro> dataRu = List.of(
                new Pro(1, "ColaRu", 9000, "https://th.bing.com/th/id/OIP.dNCYKENMQT0e6qVY3uzTzQHaE7?pid=ImgDet&rs=1")
        );
        return ResponseEntity.ok(lang.equals("uz")? data : dataRu);
    }

}
