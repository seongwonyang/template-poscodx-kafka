forEach: Command
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/dto
fileName: {{namePascalCase}}Dto.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.dto;

public class {{namePascalCase}}Dto {
    {{#fieldDescriptors}}
    private {{className}} {{nameCamelCase}};
    {{/fieldDescriptors}}
}
