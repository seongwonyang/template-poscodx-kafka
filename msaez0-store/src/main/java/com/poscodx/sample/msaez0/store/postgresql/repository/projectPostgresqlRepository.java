forEach: Aggregate
path: {{boundedContext.nameCamelCase}}/{{boundedContext.nameCamelCase}}-store/src/main/java/com/poscodx/{{options.serviceId}}/{{boundedContext.nameCamelCase}}/store/postgresql/repository
fileName: {{namePascalCase}}PostgresqlRepository.java
---
package com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.postgresql.repository;

import com.poscodx.{{options.serviceId}}.{{boundedContext.nameCamelCase}}.store.postgresql.jpo.{{namePascalCase}}Jpo;
import org.springframework.data.jpa.repository.JpaRepository;


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
public interface {{namePascalCase}}PostgresqlRepository
    extends JpaRepository<{{namePascalCase}}Jpo, Integer>
{
}
