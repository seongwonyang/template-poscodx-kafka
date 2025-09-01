forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/{{options.serviceId}}/{{boundedContext.nameCamelCase}}/store/postgresql
fileName: {{namePascalCase}}PostgresqlStore.java
---
package com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.postgresql;

import java.util.List;
import java.util.Optional;
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.domain.entity.{{namePascalCase}};
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.postgresql.jpo.{{namePascalCase}}Jpo;
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.postgresql.repository.{{namePascalCase}}PostgresqlRepository;
import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.{{namePascalCase}}Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


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
@Repository
public class {{namePascalCase}}PostgresqlStore
    implements {{namePascalCase}}Store
{
    private final {{namePascalCase}}PostgresqlRepository repository;

    @Override
    public List<{{namePascalCase}}> retrieveAll() {
        List<{{namePascalCase}}Jpo> jpos = this.repository.findAll();
        return {{namePascalCase}}Jpo.toDomains(jpos);
    }

    @Override
    public {{namePascalCase}} retrieve(Integer id) {
        Optional<{{namePascalCase}}Jpo> retVal = this.repository.findById(id);
        if (retVal.isPresent()) {
            return retVal.get().toDomain();
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public {{namePascalCase}} update({{namePascalCase}} entity) {
        {{namePascalCase}}Jpo jpoToUpdate = new {{namePascalCase}}Jpo(entity);
        {{namePascalCase}}Jpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public {{namePascalCase}} create({{namePascalCase}} entity) {
        {{namePascalCase}}Jpo jpoToSave = new {{namePascalCase}}Jpo(entity);
        {{namePascalCase}}Jpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }
}
