forEach: View
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/dto
fileName: {{namePascalCase}}Dto.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto;
{{#queryParameters}}{{^if (isPrimitive className)}}import com.poscodx.sample.{{../boundedContext.nameCamelCase}}.store.domain.vo.{{removeList className}};{{/if}}{{/queryParameters}}

import java.util.List;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import java.util.Date;
import jakarta.persistence.Id;

// View DTO
public class {{namePascalCase}}Dto {
    
    {{#queryParameters}}
    {{#isKey}}
        @Id
    {{/isKey}}
        private {{{className}}} {{nameCamelCase}};
    {{/queryParameters}}

}

<function>
this.contexts.isNotCQRS = this.dataProjection!="cqrs"
    
window.$HandleBars.registerHelper('checkBigDecimal', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className.includes('BigDecimal')){
            return "import java.math.BigDecimal;";
        }
    }
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