forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-facade/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/facade/rest/feature
fileName: {{namePascalCase}}FlowResource.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.facade.rest.feature;

import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
{{#commands}}
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/commands}}
{{#attached 'View' this}}
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/attached}}

import com.poscodx.sample.{{boundedContext.nameCamelCase}}.feature.flow.{{namePascalCase}}Flow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// kafka
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Auto generated class
 * 
 * 자동생성 프로그램 버전 : 1.0.0
 * 생성일시 :  2025-06-25 09:50:25.681
 * @FileName : 클래스에 대한 한글 명칭
 * Change history
 * @수정날짜;SCR_NO;수정자;수정내용
 * @2025-06-25 09:50:25.681;00000;홍길동;최초생성
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
    
    /* 
    // TODO : Biz Logic 구현 
    // 1. 필요한 컴포넌트 선언 
    private final SomeComponent someComponent; 
    private final SomeLogic someLogic; 
    private final SomeAction someAction; 
    private final SomeFlow someFlow; 

    // 2. 필요한 메소드 정의 및 구현 
    public void someMethod() { 
        someComponent.someMethod(); 
        someLogic.someMethod(); 
        someAction.someMethod(); 
        someFlow.someMethod(); 
        flow.someMethod(); 
    } 
    public String someMessageTest(Locale locale, String ... args) { 
        return messageSource.getMessage("SOME_MESSAGE_ID", args, locale);
    } 
    */ 

    // command
    {{#commands}}
    {{#if isRestRepository}}
    {{else}}
    @GetMapping("/{{nameCamelCase}}")
    public void {{nameCamelCase}}(@RequestBody {{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        flow.someMethod();

        {{#outgoing 'Event' this}}
        streamBridge.send("{{nameCamelCase}}-out-0",
                MessageBuilder.withPayload(orderJson).build());
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
