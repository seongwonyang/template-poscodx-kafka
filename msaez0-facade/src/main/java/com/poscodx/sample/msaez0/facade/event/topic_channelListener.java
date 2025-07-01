forEach: BoundedContext
path: {{nameCamelCase}}/{{nameCamelCase}}-facade/src/main/java/com/poscodx/sample/{{nameCamelCase}}/facade/event
fileName: topic_channelListener.java
---
package com.poscodx.sample.{nameCamelCase}.facade.event;

import java.util.function.Consumer;
import com.poscodx.reuse.common.util.kafka.annotation.PosEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


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
@Component("topic_channel")
public class topic_channelListener
    implements Consumer<Message<String>>
{

    @PosEventHandler
    @Override
    public void accept(Message<String> message) {
        String payload = message.getPayload();
        // TODO
        // T obj = JsonUtil.fromJson(payload, T)
        // someFlow.someMethod(obj)
    }
    
    // TODO 
    // private final SomeFlow someFlow; 

}
