forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/entity
fileName: {{namePascalCase}}.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity;
{{#aggregateRoot.fieldDescriptors}}{{^if (isPrimitive className)}}import com.poscodx.sample.{{../boundedContext.nameCamelCase}}.store.domain.vo.{{removeList className}};{{/if}}{{/aggregateRoot.fieldDescriptors}}

import java.sql.Timestamp;
import com.poscodx.base.share.domain.PoscoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Embedded;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;


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
@Getter
@Setter
@NoArgsConstructor
public class {{namePascalCase}}
    extends PoscoEntity
{
    {{#aggregateRoot.fieldDescriptors}}
    {{^isVO}}
    {{#isKey}}
    @Id
    {{#checkClassType ../aggregateRoot.fieldDescriptors}}{{/checkClassType}}
    {{/isKey}}
    {{/isVO}}
    {{#isLob}}@Lob{{/isLob}}
    {{#if (isPrimitive className)}}{{#isList}}{{/isList}}{{/if}}
    {{#checkFieldType className isVO namePascalCase isKey ../aggregateRoot.entities.relations}}{{/checkFieldType}}
    {{#checkEntityField className nameCamelCase isVO label}}
    {{/checkEntityField}}
    {{/aggregateRoot.fieldDescriptors}}
}


<function>
window.$HandleBars.registerHelper('checkClassType', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className == 'Long'){
            // return "@GeneratedValue(strategy=GenerationType.AUTO)";
            return "";
        }
    }
    return "";
});

window.$HandleBars.registerHelper('isPrimitive', function (className) {
    if(className.includes("String") || className.includes("Integer") || className.includes("Long") || className.includes("Double") || className.includes("Float")
            || className.includes("Boolean") || className.includes("Date")){
        return true;
    } else {
        return false;
    }
});

window.$HandleBars.registerHelper('checkFieldType', function (className, isVO, name, isKey, relation) {
    try {
        if (className === "Integer" || className === "String" || className === "Boolean" || className === "Float" || 
           className === "Double" || className === "Long" || className === "Date" || className === "BigDecimal") {
            return;
        }
        
        if (className.includes("List")) {
            const foundRelation = relation.find(rel => 
                rel && rel.name === name && !rel.targetElement._type.endsWith("enum"));
                
            if (foundRelation) {
                var aggName = foundRelation.sourceElement.name;
                aggName = aggName.charAt(0).toLowerCase() + aggName.slice(1);
                if (foundRelation.targetElement.isVO) {
                    return "@ElementCollection";
                } else {
                    return "@OneToMany(mappedBy = \"" + aggName + "\", cascade = CascadeType.ALL, orphanRemoval = true)";
                }
            }else{
                if(className.includes("List<")){
                    return "@ElementCollection";
                }else{
                    return "@Enumerated(EnumType.STRING)";
                }
            }
        } else {
            if (isVO === true) {
                if (isKey === true) {
                    return "@EmbeddedId";
                } else {
                    return "@Embedded";
                }
            } else if (relation) {
                const fields = relation.filter(field => field != null);
                
                const foundField = fields.find(field => 
                    field && field.name === name && field.targetElement);

                var aggName = foundField.sourceElement.name;
                aggName = aggName.charAt(0).toLowerCase() + aggName.slice(1);
                    
                if (foundField) {
                    if (className === foundField.targetElement.namePascalCase && 
                        foundField.targetElement._type.endsWith("enum")) {
                        return "@Enumerated(EnumType.STRING)";
                    } else if (foundField.targetElement.isVO) {
                        return "@Embedded";
                    } else {
                        return "@OneToOne(mappedBy = \"" + aggName + "\", cascade = CascadeType.ALL, orphanRemoval = true)";
                    }
                }
            }
        }
    } catch (e) {
        console.log(e);
    }
});

window.$HandleBars.registerHelper('checkEntityField', function (type, name, isVO, label) {
    if(type.includes("List<") && !isVO && label){
        return "private" + " " + type + " " + name + " " + "= " + "new java.util.ArrayList<>();";
    }else{
        return "private" + " " + type + " " + name + ";";
    }
});

window.$HandleBars.registerHelper('removeList', function (className) {
    if(className.includes("List<")) {
        className = className.replace("List<", "").replace(">", "");
    }
    return className;
});
</function>