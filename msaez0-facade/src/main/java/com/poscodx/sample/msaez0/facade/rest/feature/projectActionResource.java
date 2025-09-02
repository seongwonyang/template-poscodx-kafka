forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-facade/src/main/java/com/poscodx/{{options.serviceId}}/{{boundedContext.nameCamelCase}}/facade/rest/feature
fileName: {{namePascalCase}}ActionResource.java
---
package com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.facade.rest.feature;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GETMapping;
import org.springframework.web.bind.annotation.PUTMapping;
import org.springframework.web.bind.annotation.DELETEMapping;
import org.springframework.web.bind.annotation.POSTMapping;
import org.springframework.web.bind.annotation.RestController;

// kafka
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.feature.action.{{namePascalCase}}Action;
{{#commands}}
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/commands}}
{{#attached 'View' this}}
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/attached}}
{{#events}}
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.event.{{namePascalCase}}Event;
{{/events}}

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
@RequestMapping(path = "/{{getRequsetMapping namePascalCase}}")
public class {{namePascalCase}}ActionResource {
    private final {{namePascalCase}}Action action;

    // kafka
    @Autowired
    private StreamBridge streamBridge;

    // command
    {{#commands}}
    {{#if isRestRepository}}
    {{else}}
    @{{controllerInfo.method}}Mapping("/{{nameCamelCase}}")
    public void {{nameCamelCase}}(@RequestBody {{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        action.someMethod();

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
        action.someMethod();
    }
    {{/attached}}

}

<function>
window.$HandleBars.registerHelper('getRequsetMapping', function (namePascalCase) {
    // 단어가 하나면 그대로 반환, camelCase면 kebab-case로 변환
    if (typeof namePascalCase !== 'string') return namePascalCase;
    // camelCase 경계(소문자/숫자 다음 대문자)가 없으면 그대로 반환
    if (!/[a-z0-9][A-Z]/.test(namePascalCase)) return namePascalCase;
    return namePascalCase.replace(/([a-z0-9])([A-Z])/g, '$1-$2').toLowerCase();
});
</function>
