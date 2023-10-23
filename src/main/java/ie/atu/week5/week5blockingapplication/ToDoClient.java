package ie.atu.week5.week5blockingapplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface ToDoClient {

    @GetMapping("/todos/1")
    ToDoResponse fetchData();

    @GetMapping("/todos/")
    List<ToDoResponse> fetchAllData();
}
