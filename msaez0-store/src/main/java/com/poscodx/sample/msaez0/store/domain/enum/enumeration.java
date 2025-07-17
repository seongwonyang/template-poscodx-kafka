forEach: Enumeration
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/enum
fileName: {{namePascalCase}}.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.enum;

public enum {{namePascalCase}} {

    {{#items}}
    {{#setItems value ../items}}{{/setItems}}
    {{/items}}
}

<function>

window.$HandleBars.registerHelper('setItems', function (value, items) {
    try {
        var text = ''
        for(var i = 0; i < items.length; i ++ ){
            if(items[i]) {
                if(items[i].value == value) {
                    text = value
                    if(i+1 < items.length) {
                        text += ','
                    } else {
                        text += ';'
                    }
                    return text
                }
            }
        }
    } catch (e) {
        console.log(e)
    }
});

</function>