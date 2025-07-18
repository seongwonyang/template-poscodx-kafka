forEach: Event
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/event
fileName: {{namePascalCase}}Event.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.event;

public class {{namePascalCase}}Event {
    {{#fieldDefinitions}}
    private {{type}} {{name}};
    {{/fieldDefinitions}}
}

