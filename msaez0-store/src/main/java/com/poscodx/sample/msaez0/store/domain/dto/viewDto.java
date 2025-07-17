forEach: View
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/dto
fileName: {{namePascalCase}}Dto.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto;

public class {{namePascalCase}}Dto {
    
    {{#fieldDescriptors}}
    {{#isKey}}
        @Id
    {{/isKey}}
        private {{className}} {{nameCamelCase}};
    {{/fieldDescriptors}}

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
</function>