forEach: Event
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/event
fileName: {{namePascalCase}}Event.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.event;
{{#fieldDescriptors}}{{^if (isPrimitive className)}}import com.poscodx.sample.{{../boundedContext.nameCamelCase}}.store.domain.vo.{{removeList className}};{{/if}}{{/fieldDescriptors}}

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

