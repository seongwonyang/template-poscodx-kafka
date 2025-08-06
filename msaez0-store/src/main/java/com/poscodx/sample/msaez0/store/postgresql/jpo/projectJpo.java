forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/postgresql/jpo
fileName: {{namePascalCase}}Jpo.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.postgresql.jpo;
{{#aggregateRoot.fieldDescriptors}}{{^if (isPrimitive className)}}import com.poscodx.sample.{{../boundedContext.nameCamelCase}}.store.domain.vo.{{removeList className}};{{/if}}{{/aggregateRoot.fieldDescriptors}}

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.poscodx.base.share.exception.PoscoException;
import com.poscodx.base.share.jpo.PoscoEntityJpo;
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


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
@Entity(name = "{{namePascalCase}}Jpo")
@Table(name = "{{namePascalCase}}", schema = "public")
public class {{namePascalCase}}Jpo
    extends PoscoEntityJpo
{
    {{#aggregateRoot.fieldDescriptors}}
    {{^isVO}}
    {{#isKey}}
    @Id
    {{#checkClassType ../aggregateRoot.fieldDescriptors}}{{/checkClassType}}
    {{/isKey}}
    {{/isVO}}
    @Column(name = "{{nameCamelCase}}")
    {{#isLob}}@Lob{{/isLob}}
    {{#if (isPrimitive className)}}{{#isList}}{{/isList}}{{/if}}
    {{#checkFieldType className isVO namePascalCase isKey ../aggregateRoot.entities.relations}}{{/checkFieldType}}
    {{#checkEntityField className nameCamelCase isVO label}}
    {{/checkEntityField}}
    {{/aggregateRoot.fieldDescriptors}}

    public {{namePascalCase}}Jpo({{namePascalCase}} entity) {
        BeanUtils.copyProperties(entity, this);
    }

    @Override
    public void validateJpo()
        throws PoscoException
    {
    }

    public {{namePascalCase}} toDomain() {
        {{namePascalCase}} entity = new {{namePascalCase}}();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }

    public static List<{{namePascalCase}}> toDomains(Iterable<{{namePascalCase}}Jpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map(({{namePascalCase}}Jpo::toDomain)).collect(Collectors.toList());
    }
}

<function>
window.$HandleBars.registerHelper('checkClassType', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className == 'Long'){
            return "@GeneratedValue(strategy=GenerationType.AUTO)";
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
</function>
