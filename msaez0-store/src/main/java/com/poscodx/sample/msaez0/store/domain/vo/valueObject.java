forEach: ValueObject
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/vo
fileName: {{namePascalCase}}.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.vo;

public class {{namePascalCase}}VO {
    {{#fieldDescriptors}}
    {{#isLob}}@Lob{{/isLob}}
    {{#if (isPrimitive className)}}{{#isList}}@ElementCollection{{/isList}}{{/if}}
    {{#checkRelations ../relations className isVO}} {{/checkRelations}}
    {{#checkClassType ../fieldDescriptors}}{{/checkClassType}}
    private {{{className}}} {{nameCamelCase}};
    {{/fieldDescriptors}}
}

//>>> DDD / Value Object
<function>
window.$HandleBars.registerHelper('checkCompositeKey', function (incomingClassRef, voName) {
    var flag = false;
    if(incomingClassRef.length > 0){
        for(var i = 0; i < incomingClassRef.length; i ++ ){
            if(incomingClassRef[i].value.isAggregateRoot){
                for(var j = 0; j < incomingClassRef[i].value.fieldDescriptors.length; j ++ ){
                    if(incomingClassRef[i].value.fieldDescriptors[j] && incomingClassRef[i].value.fieldDescriptors[j].className===voName && incomingClassRef[i].value.fieldDescriptors[j].isKey){
                        flag = true;
                    }
                }
            }
        }
    }
    return flag;
});
window.$HandleBars.registerHelper('checkClassType', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i++) {
        if(fieldDescriptors[i].isKey && fieldDescriptors[i].className === 'Long'){
            return "@GeneratedValue(strategy=GenerationType.AUTO)";
        }
    }
    return;
});
window.$HandleBars.registerHelper('mergeType', function (type) {
    if(type.includes('enum')) {
        return 'template'
    } else {
        return 'merge'
    }
});

window.$HandleBars.registerHelper('checkBigDecimal', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className.includes('BigDecimal')){
            return "import java.math.BigDecimal;";
        }
    }
});

window.$HandleBars.registerHelper('isPrimitive', function (className) {
    if(className.includes("String") || className.includes("Integer") || className.includes("Long") || className.includes("Double") || className.includes("Float")
            || className.includes("Boolean") || className.includes("Date")){
        return true;
    } else {
        return false;
    }
});

window.$HandleBars.registerHelper('checkRelations', function (relations, className, isVO) {
    try {
        if(typeof relations == "undefined") {
            return
        } else {
            // primitive type
            if(className.includes("String") || className.includes("Integer") || className.includes("Long") || className.includes("Double") || className.includes("Float")
                    || className.includes("Boolean") || className.includes("Date")) {
                if(className.includes("List")) {
                    return "@ElementCollection"
                }
            } else {
                // ValueObject
                if(isVO) {
                    if(className.includes("List")) {
                        return "@ElementCollection"
                    } else {
                        return "@Embedded"
                    }
                } else {
                    for(var i = 0; i < relations.length; i ++ ) {
                        if(relations[i] != null) {
                            if(relations[i].targetElement == null) {
                                if(className.includes(relations[i].toName) && !relations[i].relationType.includes("Generalization")){
                                    // Enumeration
                                    if(relations[i].targetType && relations[i].targetType.includes('enum')) {
                                        return '@Enumerated(EnumType.STRING)'
                                    } 
                                }
                            } else {
                                if(className.includes(relations[i].targetElement.name) && !relations[i].relationType.includes("Generalization")) {
                                    // Enumeration
                                    if(relations[i].targetElement._type.endsWith('enum')) {
                                        return '@Enumerated(EnumType.STRING)'
                                    }
                                }
                            }
                            // complex type
                            if(relations[i].sourceMultiplicity == "1" && className.includes("List")){
                                return "@OneToMany"
                            } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") 
                                    && relations[i].targetMultiplicity == "1"){
                                return "@ManyToOne"
                            } else if(relations[i].sourceMultiplicity == "1" && relations[i].targetMultiplicity == "1"){
                                return "@OneToOne"
                            } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") && className.includes("List")){
                                return "@ManyToMany"
                            }
                        }
                    }
                }
            }

            for(var i = 0; i < relations.length; i ++ ) {
                if(relations[i] != null){
                    if(relations[i].targetElement == null) {
                        if(className.includes(relations[i].toName) && !relations[i].relationType.includes("Generalization")){
                            if(relations[i].targetType && relations[i].targetType.includes('enum')) {
                                return '@Enumerated(EnumType.STRING)'
                            } else {
                                if(isVO) {
                                    if((relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n") && relations[i].sourceMultiplicity == "1"){
                                        return "@ElementCollection"
                                    } else {
                                        return "@Embedded"
                                    }
                                } else {
                                    if(relations[i].sourceMultiplicity == "1" && (relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n")){
                                        return "@OneToMany"
                                    } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") && relations[i].targetMultiplicity == "1"){
                                        return "@ManyToOne"
                                    } else if(relations[i].sourceMultiplicity == "1" && relations[i].targetMultiplicity == "1"){
                                        return "@OneToOne"
                                    } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") && (relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n")){
                                        return "@ManyToMany"
                                    }
                                }
                            }
                        }
                    } else {
                        if(className.includes(relations[i].targetElement.name) && !relations[i].relationType.includes("Generalization")) {
                            if(relations[i].targetElement._type.includes('enum')) {
                                return '@Enumerated(EnumType.STRING)'
                            } else {
                                if(isVO) {
                                    if((relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n") && relations[i].sourceMultiplicity == "1"){
                                        return "@ElementCollection"
                                    } else {
                                        return "@Embedded"
                                    }
                                } else {
                                    if(relations[i].sourceMultiplicity == "1" && (relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n")){
                                        return "@OneToMany"
                                    } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") && relations[i].targetMultiplicity == "1"){
                                        return "@ManyToOne"
                                    } else if(relations[i].sourceMultiplicity == "1" && relations[i].targetMultiplicity == "1"){
                                        return "@OneToOne"
                                    } else if((relations[i].sourceMultiplicity == "1..n" || relations[i].sourceMultiplicity == "0..n") && (relations[i].targetMultiplicity == "1..n" || relations[i].targetMultiplicity == "0..n")){
                                        return "@ManyToMany"
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return
        }
    } catch (e) {
        console.log(e)
    }
});

</function>