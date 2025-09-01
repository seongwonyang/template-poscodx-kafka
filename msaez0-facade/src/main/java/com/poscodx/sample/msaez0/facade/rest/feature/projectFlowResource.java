forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-facade/src/main/java/com/poscodx/{{options.serviceId}}/{{boundedContext.nameCamelCase}}/facade/rest/feature
fileName: {{namePascalCase}}FlowResource.java
---
package com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.facade.rest.feature;

import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
{{#commands}}
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/commands}}
{{#attached 'View' this}}
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/attached}}

import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.feature.flow.{{namePascalCase}}Flow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// kafka
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Auto generated class
 * 
 * 자동생성 프로그램 버전 : 1.0.0
 * 생성일시 :  {{currentTimeStamp}}
 * @FileName : 클래스에 대한 한글 명칭
 * Change history
 * @수정날짜;SCR_NO;수정자;수정내용
 * @{{currentTimeStamp}};00000;홍길동;최초생성
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/{{nameCamelCase}}-flow")
public class {{namePascalCase}}FlowResource {
    private final {{namePascalCase}}Flow flow;

    // kafka
    @Autowired
    private StreamBridge streamBridge;

    // command
    {{#commands}}
    {{#if isRestRepository}}
    {{else}}
    @GetMapping("/{{nameCamelCase}}")
    public void {{nameCamelCase}}(@RequestBody {{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        flow.someMethod();

        {{#outgoing 'Event' this}}
        streamBridge.send("{{nameCamelCase}}-out-0",
                MessageBuilder.withPayload({{namePascalCase}}Event.toJson()).build());
        {{/outgoing}}
    }
    {{/if}}
    {{/commands}}

    // view
    {{#attached 'View' this}}
    @GetMapping("/{{nameCamelCase}}")
    public {{../namePascalCase}} {{nameCamelCase}}(@RequestBody {{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        flow.someMethod();
    }
    {{/attached}}

}
