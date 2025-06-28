package com.evry.analytics.DTO;

import com.evry.analytics.model.entity.Visitor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
public class VisitorDTO {

    public VisitorDTO() {}

    public VisitorDTO(Visitor visitor) {
        if (visitor != null) {
            createDate = visitor.getCreateDate();
            uuid = String.valueOf(visitor.getUuid());
            userId = visitor.getUserId();
        }
    }

    private LocalDateTime createDate;

    private String uuid;

    private String userId;
}
