forEach: BoundedContext
path: {{nameCamelCase}}/{{nameCamelCase}}-proxy/src/main/java/com/poscodx/sample/{{nameCamelCase}}/proxy/client
fileName: {{nameCamelCase}}Client.java
---

import com.poscodx.reuse.common.audit.web.JsonWebTokenReader;
import com.poscodx.reuse.common.audit.web.AuthorizedUserInfo;

@RestController
@RequestMapping("/api/v1/projects")
public class projectClient {

    private final JsonWebTokenReader jsonWebTokenReader;

    @GetMapping(path = "/{id}")
    public void someMethod() {
        WebClient webClient = null;
        String result = client.get().uri("/callee/some-endpoint")
            .headers(httpHeaders -> {
                httpHeaders.add("token", token);
            })
            .accept(MediaType.APPLICATION_JSON)
            .bodyToMono(String.class)
            .block();

    }
}