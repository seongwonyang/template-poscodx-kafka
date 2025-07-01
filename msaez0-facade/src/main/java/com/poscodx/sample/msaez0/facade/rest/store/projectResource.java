forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-facade/src/main/java/com/poscodx/sample/{{boundedContext.nameCamelCase}}/facade/rest/store
fileName: {{namePascalCase}}Resource.java
---
package com.poscodx.sample.{{boundedContext.nameCamelCase}}.facade.rest.store;

import java.util.List;
import com.poscodx.base.share.domain.NameValueList;
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.sample.{{boundedContext.nameCamelCase}}.store.domain.logic.{{namePascalCase}}Logic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
@CrossOrigin("*")
@RestController
@RequestMapping(path = "/{{nameCamelCase}}")
public class {{namePascalCase}}Resource {
    private final {{namePascalCase}}Logic logic;

    @GetMapping(path = "/all")
    public List<{{namePascalCase}}> findAll() {
        return this.logic.findAll();
    }

    @GetMapping(path = "/{id}")
    public {{namePascalCase}} find(@PathVariable("id") Integer id) {
        return this.logic.find(id);
    }

    @PostMapping
    public {{namePascalCase}} register(@org.springframework.web.bind.annotation.RequestBody {{namePascalCase}} entity) {
        return this.logic.register(entity);
    }

    @PutMapping(path = "/{id}")
    public {{namePascalCase}} modify(@PathVariable("id") Integer id, @org.springframework.web.bind.annotation.RequestBody NameValueList nameValues) {
        return this.logic.modify(id, nameValues);
    }

    @DeleteMapping(path = "/{id}")
    public void remove(@PathVariable("id") Integer id) {
        this.logic.remove(id);
    }
}
