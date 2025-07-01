forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/store/domain/logic
fileName: {{namePascalCase}}Logic.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.logic;

import java.util.List;
import com.poscodx.base.share.domain.NameValueList;
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.projectStore;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


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
@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class {{namePascalCase}}Logic {
    private final MessageSource messageSource;
    private final {{namePascalCase}}Store store;

    public List<{{namePascalCase}}> findAll() {
        return this.store.retrieveAll();
    }

    public {{namePascalCase}} find(Integer id) {
        return this.store.retrieve(id);
    }

    public void remove(Integer id) {
        this.store.delete(id);
    }

    public {{namePascalCase}} register({{namePascalCase}} entity) {
        return this.store.create(entity);
    }

    public {{namePascalCase}} modify(Integer id, NameValueList nameValues) {
        {{namePascalCase}} entity = this.store.retrieve(id);
        entity.setValues(nameValues);
        return this.store.update(entity);
    }
}
