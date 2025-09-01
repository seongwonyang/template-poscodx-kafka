forEach: Event
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/{{options.serviceId}}/{{boundedContext.nameCamelCase}}/store/domain/event
fileName: {{namePascalCase}}Event.java
---
package com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.event;
{{#fieldDescriptors}}{{^if (isPrimitive className)}}import com.poscodx.{{options.serviceId}}.{{../boundedContext.nameCamelCase}}.store.domain.vo.{{removeList className}};{{/if}}{{/fieldDescriptors}}

import java.util.List;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import java.util.Date;

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
// Event
public class {{namePascalCase}}Event {
    {{#fieldDescriptors}}
    private {{{className}}} {{nameCamelCase}};
    {{/fieldDescriptors}}
}

<function>
window.$HandleBars.registerHelper('removeList', function (className) {
    if(className.includes("List<")) {
        className = className.replace("List<", "").replace(">", "");
    }
    return className;
});

window.$HandleBars.registerHelper('isPrimitive', function (className) {
    if(className.includes("String") || className.includes("Integer") || className.includes("Long") || className.includes("Double") || className.includes("Float")
            || className.includes("Boolean") || className.includes("Date") || className.includes("int")){
        return true;
    } else {
        return false;
    }
});
</function>

