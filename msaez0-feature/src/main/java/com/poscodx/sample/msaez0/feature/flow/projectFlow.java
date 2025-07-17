forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-feature/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/feature/flow
fileName: {{namePascalCase}}Flow.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.feature.flow;

import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.feature.action.{{namePascalCase}}Action;
{{#commands}}
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}}Dto;
{{/commands}}
{{#attached 'View' this}}
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto.{{namePascalCase}};
{{/attached}}
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


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
@Service
@Transactional
public class {{namePascalCase}}Flow {
    private final MessageSource messageSource;
    private final {{namePascalCase}}Action action;
    
    /* 
    // TODO : Biz Logic 구현 
    // 1. 필요한 컴포넌트 선언 
    private final SomeComponent someComponent; 
    private final SomeLogic someLogic; 
    private final SomeAction someAction; 

    // 2. 필요한 메소드 정의 및 구현 
    public void someMethod() { 
        someComponent.someMethod(); 
        someLogic.someMethod(); 
        someAction.someMethod(); 
        action.someMethod(); 
    } 
    public String someMessageTest(Locale locale, String ... args) { 
        return messageSource.getMessage("SOME_MESSAGE_ID", args, locale);
    } 
    */ 

    // command
    {{#commands}}
    {{#if isRestRepository}}
    {{else}}
    public void {{nameCamelCase}}({{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        action.someMethod();
    }
    {{/if}}
    {{/commands}}

    // view
    {{#attached 'View' this}}
    public {{../namePascalCase}} {{nameCamelCase}}({{namePascalCase}}Dto {{nameCamelCase}}Dto) {
        action.someMethod();
    }
    {{/attached}}
}
