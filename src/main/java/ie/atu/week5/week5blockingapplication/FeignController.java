package ie.atu.week5.week5blockingapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

  @GetMapping("/feign")
    public String getFeignData() throws Exception, InterruptedException{
      long startTime = System.currentTimeMillis();

      List<CompletableFuture<ToDoResponse>> futures = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
          CompletableFuture<ToDoResponse> future = CompletableFuture.supplyAsync(() -> feignService.fetchData());
          futures.add(future);
      }

      CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
      allOf.get();
      long endTime = System.currentTimeMillis();

      return "Total execution time: " + (endTime - startTime) + "as";
  }
}
